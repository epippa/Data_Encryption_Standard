
public class TestSingleBlock {

	public static void main(String[] args) {
		
		String key = "0001001100110100010101110111100110011011101111001101111111110001";
		String plaintext = "0000000100100011010001010110011110001001101010111100110111101111";
		
		String[] keys = new SubKeysGenerator().generateSubKeys(key);
		System.out.println("\n" + "GENERATED SUBKEYS-----" + "\n");
		
		for(String k : keys) {
			System.out.println(k);
		}
	
		System.out.println("\n" + "BLOCK AFTER INITIAL PERMUTATION-----" + "\n");
		// Initial Permutation
		
		String ip = new BlockEncoder().encodeBlock(plaintext);
		System.out.println("IP = " + ip);		
		
		String ciphertext = new RoundPerformer().performRoundsEncryption(ip, keys);
		System.out.println("\n" + "CIPHERTEXT = " + ciphertext);
	}

}