
public class SubKeysGenerator {

	private static int[] PC1 = 
		{  
				57, 49, 41, 33, 25, 17,  9,
				1, 58, 50, 42, 34, 26, 18,
				10,  2, 59, 51, 43, 35, 27,
				19, 11,  3, 60, 52, 44, 36,
				63, 55, 47, 39, 31, 23, 15,
				7, 62, 54, 46, 38, 30, 22,
				14,  6, 61, 53, 45, 37, 29,
				21, 13,  5, 28, 20, 12,  4
		};

	private static int[] PC2 = 
		{
				14, 17, 11, 24,  1,  5,
				3, 28, 15,  6, 21, 10,
				23, 19, 12,  4, 26,  8,
				16,  7, 27, 20, 13,  2,
				41, 52, 31, 37, 47, 55,
				30, 40, 51, 45, 33, 48,
				44, 49, 39, 56, 34, 53,
				46, 42, 50, 36, 29, 32
		};

	private static int[] KEY_SHIFTS = 
		{
				1,  1,  2,  2,  2,  2,  2,  2,  1,  2,  2,  2,  2,  2,  2,  1
		};

// binkey, binKey_PC1, binKey_PC2 are binary strings
	public String[] generateSubKeys(String binkey) {
		String[] keys = new String[16];
		// Reduce the input key to a 56-bit permuted key 
		String binKey_PC1 = "";

		// Apply Permuted Choice 1 (64 -> 56 bit)
		for (int i = 0; i < PC1.length; i++) {
		//	binKey_PC1 = binKey_PC1 + ...;
			binKey_PC1 += binkey.charAt(PC1[i] - 1);
		}
		String Cn_minus_1, Dn_minus_1, Cn, Dn;
		System.out.println(binKey_PC1.length());
		// Split permuted string in half | 56/2 = 28
		Cn_minus_1 = binKey_PC1.substring(0, 28);
		Dn_minus_1 = binKey_PC1.substring(28);
		//---------------------------------
		//for i from 0 to 15 compute key[i]
		for (int i = 0; i < 16; i++) {
			Cn = Utils.cyclicLeftShift(Cn_minus_1, KEY_SHIFTS[i]);
			Dn = Utils.cyclicLeftShift(Dn_minus_1, KEY_SHIFTS[i]);
			Cn_minus_1 = Cn;
			Dn_minus_1 = Dn;

			String perm = Cn + Dn;
			String binKey_PC2 = "";

			for (int j = 0; j < PC2.length; j++) {
				binKey_PC2 += perm.charAt(PC2[j] - 1);
			}
			System.out.println(binKey_PC2);
			keys[i] = binKey_PC2;
		}
		
		return keys;
	}
}
