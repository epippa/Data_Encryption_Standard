public class DES {

    // Abilita le stampe di debug impostando a true
    private static final boolean DEBUG = false;

    private String[] getBlocks(String plaintext) {
        //convert plaintext to binary
        String plainToBin = Utils.textToBinary(plaintext);
        //pad the plaintext to obtain blocks of 64 bits
        plainToBin = Utils.padsPlaintext(plainToBin,64); //multiplo di 64 con zeri alla fine
        //split the plaintext into blocks of 64 bits
        String[] blocks = Utils.splitEqually(plainToBin, 64);
        return blocks;
    }

    public String encryptECB (String plaintext, String key) {
        String[] blocks = getBlocks(plaintext);
        //generate sub keys
        String[] keys = new SubKeysGenerator().generateSubKeys(key);
        String ip="";
        String ciphertext="";
        for(int i = 0; i<blocks.length; i++) {
            //encrypt each block
            //concatenate the encrypted blocks into a single ciphertext 
            ip = new BlockEncoder().encodeBlock(blocks[i]);        
            ciphertext = ciphertext + new RoundPerformer().performRoundsEncryption(ip, keys);
        }
        //return the ciphertext;
        if (DEBUG) System.out.println("ciphertext ECB: " + ciphertext);
        return ciphertext;
    }

    public String encryptCBC (String plaintext, String key, String iv) {
        String[] blocks = getBlocks(plaintext);
        String ip = "";
        String ciphertext = "";
        String[] keys = new SubKeysGenerator().generateSubKeys(key);
        for(int i = 0; i<blocks.length; i++) {
            //xor iv with the plaintext block
            String xor = Utils.computeXOR(iv, blocks[i]);
            ip = new BlockEncoder().encodeBlock(xor);
            //perform the encryption
            String currentCiphertext = new RoundPerformer().performRoundsEncryption(ip, keys);
            //concatenate the encrypted blocks into a single ciphertext
            ciphertext = ciphertext + currentCiphertext;
            //the current ciphertext block becomes the new iv 
            iv = currentCiphertext;        
        }
        if (DEBUG) System.out.println("ciphertext CBC: " + ciphertext);
        return ciphertext;
    }

    public String decryptECB (String ciphertext, String key) {
        //generate sub keys
        String[] keys = new SubKeysGenerator().generateSubKeys(key);
        //pad the ciphertext to obtain blocks of 64 bits
        //String ciphToBin = Utils.padsPlaintext(ciphertext,64);
        //split the ciphertext into blocks of 64 bits
        if (ciphertext.length() % 64 != 0) {
            throw new IllegalArgumentException("Ciphertext length is not a multiple of 64 bits");
        }
        String[] blocks = Utils.splitEqually(ciphertext, 64);
        
        String ip="";
        String plaintext="";

        for(int i = 0; i<blocks.length; i++) {
            //decrypt each block
            ip = new BlockEncoder().encodeBlock(blocks[i]);        
            //concatenate the decrypted blocks into a single plaintext 
            plaintext = plaintext + new RoundPerformer().performRoundsDecryption(ip, keys);
        }
    
        // rimuovi eventuale padding in byte interi
        String unpadded = Utils.unpad(plaintext);
        // converte in testo e restituisce
        return Utils.binaryToText(unpadded);

    }

    public String decryptCBC (String ciphertext, String key, String iv) {
        //generate sub keys
        String[] keys = new SubKeysGenerator().generateSubKeys(key);
        //pad the ciphertext to obtain blocks of 64 bits
        //String ciphToBin = Utils.padsPlaintext(ciphertext,64);
        //split the ciphertext into blocks of 64 bits
        if (ciphertext.length() % 64 != 0) {
            throw new IllegalArgumentException("Ciphertext length is not a multiple of 64 bits");
        }
        String[] blocks = Utils.splitEqually(ciphertext, 64);
        String plaintext="";
        String ip="";
        String xor="";
        for(int i = 0; i<blocks.length; i++) {
            //decrypt each block
            ip = new BlockEncoder().encodeBlock(blocks[i]);        
            //concatenate the decrypted blocks into a single plaintext
            String currentPlaintext = new RoundPerformer().performRoundsDecryption(ip, keys);
            //xor iv with the plaintext block
            xor = Utils.computeXOR(currentPlaintext, iv);
            //concatenate the decrypted blocks into a single plaintext 
            plaintext = plaintext + xor;
            //the current ciphertext block becomes the new iv 
            iv=blocks[i];
        }
        //remove the zero-bytes at the end of the plaintext
        String unpadded = Utils.unpad(plaintext);
        //convert the plaintext to text and return it;
        return Utils.binaryToText(unpadded);
    }
}
