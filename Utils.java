import java.math.BigInteger;

public class Utils {

	public static String cyclicLeftShift(String s, int k){
		k = k%s.length();
		return s.substring(k) + s.substring(0, k);
	}

	public static String computeXOR(String str1, String str2) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < str1.length(); i++) {
			sb.append(str1.charAt(i)^str2.charAt(i));
		}
		return sb.toString();
	}

	public static String[] splitEqually(String str, int size) {
		String[] ret = new String[(str.length()) / size];
		int i = 0;
		for (int start = 0; start < str.length(); start += size) {
			ret[i] =  str.substring(start, Math.min(str.length(), start + size));
			i++;
		}
		return ret;
	}

	public static int binaryToDecimal(String str){  
		return Integer.parseInt(str,2);  
	}  

	public static String decimalToBinary(int dec){  
		return Integer.toBinaryString(dec);  
	}

	public static String decimalToBinary(BigInteger dec){  
		return dec.toString(2);  
	}

	public static String padsPlaintext(String str, int size) {
		int m = str.length() % size;
		if(m>0) {
			int zerosToAdd = size - m;
			for(int i=0; i<zerosToAdd;i++) {
				str = str +"0";
			}
		}
		return str;
	}

	public static String padsBinaryToSize(String str, int size) {
		String pad = "";
		if(str.length()<size) {
			for(int j=0; j<size-str.length();j++) {
				pad = pad+"0";
			}
			str = pad + str;
		}
		return str;
	}

	public static String binaryToText(String binaryString) {    
		String str = "";
		for (int i = 0; i < binaryString.length()/8; i++) {
			int a = Integer.parseInt(binaryString.substring(8*i,(i+1)*8),2);
			str += (char)(a);
		}
		return str;
	}

	public static String textToBinary(String text) {    		
		byte[] bytes = text.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes)
		{
			int val = b;
			for (int i = 0; i < 8; i++)
			{
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			binary.append(' ');
		}
		return binary.toString().replace(" ", "");
	}
	 /*
	 * Rimuove il padding (byte di zeri) aggiunto a destra del plaintext  
	 * solo se gli zeri occupano un intero byte (8 bit).  
	 */  
	public static String unpad(String str) {  
		int len   = str.length();  
		int right = len;  

		for (int i = 1; i < len && str.charAt(len - i) == '0'; i++) {  
			if ((i + 1) % 8 == 0) {      // trovato un intero byte di zeri  
				right -= 8;              // accorcia la stringa di 8-bit  
			}  
		}  
		return str.substring(0, right);  
	}

}