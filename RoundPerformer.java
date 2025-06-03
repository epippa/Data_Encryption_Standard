public class RoundPerformer {

	private static int[] E = 
		{
				32,  1,  2,  3,  4,  5,
				4,  5,  6,  7,  8,  9, 
				8,  9, 10, 11, 12, 13, 
				12, 13, 14, 15, 16, 17,
				16, 17, 18, 19, 20, 21, 
				20, 21, 22, 23, 24, 25, 
				24, 25, 26, 27, 28, 29, 
				28, 29, 30, 31, 32,  1
		};

	private static int[][] s1 = {
			{14, 4, 13,  1,  2, 15, 11,  8,  3, 10,  6, 12,  5,  9,  0,  7},
			{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11,  9,  5,  3,  8},
			{4, 1, 14,  8, 13,  6, 2, 11, 15, 12,  9,  7,  3, 10,  5,  0},
			{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}
	};

	private static int[][] s2 = {
			{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
			{3, 13,  4, 7, 15,  2,  8, 14, 12,  0, 1, 10,  6,  9, 11,  5},
			{0, 14, 7, 11, 10,  4, 13,  1,  5,  8, 12,  6,  9,  3,  2, 15},
			{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14,  9}
	};

	private static int[][] s3 = {
			{10, 0, 9, 14, 6, 3, 15, 5,  1, 13, 12, 7, 11, 4, 2,  8},
			{13, 7, 0, 9, 3,  4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
			{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14,  7},
			{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}
	};

	private static int[][] s4 = {
			{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
			{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14,  9},
			{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
			{3, 15, 0, 6, 10, 1, 13, 8, 9,  4, 5, 11, 12, 7, 2, 14}
	};

	private static int[][] s5 = {
			{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
			{14, 11, 2, 12,  4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
			{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
			{11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}
	};

	private static int[][] s6 = {
			{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
			{10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
			{9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
			{4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13}
	};

	private static int[][] s7 = {
			{4, 11, 2, 14, 15,  0, 8, 13 , 3, 12, 9 , 7,  5, 10, 6, 1},
			{13 , 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
			{1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
			{6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}
	};

	private static int[][] s8 = {
			{13, 2, 8,  4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
			{1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6 ,11, 0, 14, 9, 2},
			{7, 11, 4, 1, 9, 12, 14, 2,  0, 6, 10 ,13, 15, 3, 5, 8},
			{2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6 ,11}
	};

	static int[] p = 
		{
				16,  7, 20, 21, 
				29, 12, 28, 17, 
				1, 15, 23, 26, 
				5, 18, 31, 10, 
				2,  8, 24, 14, 
				32, 27,  3,  9, 
				19, 13, 30,  6, 
				22, 11,  4, 25
		};

	static int[] FP = 
		{
				40, 8, 48, 16, 56, 24, 64, 32,
				39, 7, 47, 15, 55, 23, 63, 31,
				38, 6, 46, 14, 54, 22, 62, 30,
				37, 5, 45, 13, 53, 21, 61, 29,
				36, 4, 44, 12, 52, 20, 60, 28,
				35, 3, 43 ,11, 51, 19, 59, 27,
				34, 2, 42, 10, 50, 18, 58, 26,
				33, 1, 41, 9, 49, 17, 57, 25
		};

	public String performRoundsEncryption(String ip, String[] keys) {

		String ciphertext = "";

		// Split ip in half | 64/2 = 32
		String Ln_minus_1 = ip.substring(0, 32);
		String Rn_minus_1 = ip.substring(32);
//------------------------------
		String Ln = "";
		String Rn = "";		
		//for n from 1 to 16
		for (int n=1; n<17;n++){
			Ln = Rn_minus_1;
			//Ln = Rn-1
			//Rn =  Utils.computeXOR(Ln-1,f(Rn-1,Kn))
			

			// computation of f(Rn-1,Kn)
			String fn = "";
			String e_Rn_minus_1 = "";
			// Apply Expansion table E to expand Rn-1
			for (int i = 0; i < E.length; i++) {
				e_Rn_minus_1 = e_Rn_minus_1 + Rn_minus_1.charAt(E[i]-1);
			}
			System.out.println("E(R0): " + e_Rn_minus_1);
			
			//Compute XOR of E(Rn-1) and Kn
			String xor = Utils.computeXOR(e_Rn_minus_1,keys[n-1]);
			System.out.println("xor = " + xor);
			//Compute the XOR of E(Rn-1) and Kn, Kn+E(Rn-1)
			
		
			//Divide the resulting string into 8 substrings of length 6
			String[] b = new String[8];
			b=Utils.splitEqually(xor, 6);
			// for i from 0 to 7
			String s = "";
			for(int i=0; i<8; i++){
				int row= Utils.binaryToDecimal(String.valueOf(b[i].charAt(0)) + b[i].charAt(5));
				//convert b[i][0]b[i][5] into a decimal row
				int column = Utils.binaryToDecimal(String.valueOf(b[i].charAt(1)) + b[i].charAt(2) + b[i].charAt(3) + b[i].charAt(4));
				String currentS ="";
				
				switch (i) {
					case 0:
						currentS = Utils.decimalToBinary(s1[row][column]);
						break;
					case 1:
						currentS = Utils.decimalToBinary(s2[row][column]);
						break;
					case 2:
						currentS = Utils.decimalToBinary(s3[row][column]);
						break;
					case 3:
						currentS = Utils.decimalToBinary(s4[row][column]);
						break;
					case 4:
						currentS = Utils.decimalToBinary(s5[row][column]);
						break;
					case 5:
						currentS = Utils.decimalToBinary(s6[row][column]);
						break;
					case 6:
						currentS = Utils.decimalToBinary(s7[row][column]);
						break;
					case 7:			
						currentS = Utils.decimalToBinary(s8[row][column]);
						break;
					default:
						break;
				}
				currentS = Utils.padsBinaryToSize((currentS), 4);
				System.out.println("s" + i+1 + "["+row+"] ["+column+"] = " + currentS + "");
				s = s + currentS;
		}

			//convert b[i][1]b[i][2]b[i]30]b[i][4] into a decimal column
			//transform si[row][column] into a binary number of 4 bits
			//compute S by merging s1(b[0])...s8(b[7])
			

			//------------------------------------------------------------------
			//note that each item s1(b[0])...s8(b[7]) should be of 4 bit and padded
			//with zeros at the beginning if the bits are less than 4
			//------------------------------------------------------------------
			
			//compute f(Rn-1,Kn) by permuting S using p
			for (int i = 0; i < p.length; i++) {
				//	fn = fn + ...;
				fn = fn + s.charAt(p[i]-1);
			}
			Rn = Utils.computeXOR(Ln_minus_1,fn);
			System.out.println(Rn);
			Ln_minus_1 = Ln;
			Rn_minus_1 = Rn;
	//------------------------------
			
			//System.out.println(xor);
		}
		//merge R16 and L16 (R16 first)
		// Apply Final Permutation FP
		String mergedCiph = Rn+Ln;
		//String ciphertext = "";
		for (int i = 0; i < FP.length; i++) {
			ciphertext = ciphertext + mergedCiph.charAt((FP[i]-1));			
		}
		System.out.println(ciphertext);
		return ciphertext;
	}	
	public String performRoundsDecryption(String ip, String[] keys) {

		String ciphertext = "";

		// Split ip in half | 64/2 = 32
		String Ln_minus_1 = ip.substring(0, 32);
		String Rn_minus_1 = ip.substring(32);
//------------------------------
		String Ln = "";
		String Rn = "";		
		//for n from 1 to 16
		for (int n=16; n>0;n--){
			Ln = Rn_minus_1;
			//Ln = Rn-1
			//Rn =  Utils.computeXOR(Ln-1,f(Rn-1,Kn))
			

			// computation of f(Rn-1,Kn)
			String fn = "";
			String e_Rn_minus_1 = "";
			// Apply Expansion table E to expand Rn-1
			for (int i = 0; i < E.length; i++) {
				e_Rn_minus_1 = e_Rn_minus_1 + Rn_minus_1.charAt(E[i]-1);
			}
			System.out.println("E(R0): " + e_Rn_minus_1);
			
			//Compute XOR of E(Rn-1) and Kn
			String xor = Utils.computeXOR(e_Rn_minus_1,keys[n-1]);
			System.out.println("xor = " + xor);
			//Compute the XOR of E(Rn-1) and Kn, Kn+E(Rn-1)
			
		
			//Divide the resulting string into 8 substrings of length 6
			String[] b = new String[8];
			b=Utils.splitEqually(xor, 6);
			// for i from 0 to 7
			String s = "";
			for(int i=0; i<8; i++){
				int row= Utils.binaryToDecimal(String.valueOf(b[i].charAt(0)) + b[i].charAt(5));
				//convert b[i][0]b[i][5] into a decimal row
				int column = Utils.binaryToDecimal(String.valueOf(b[i].charAt(1)) + b[i].charAt(2) + b[i].charAt(3) + b[i].charAt(4));
				String currentS ="";
				
				switch (i) {
					case 0:
						currentS = Utils.decimalToBinary(s1[row][column]);
						break;
					case 1:
						currentS = Utils.decimalToBinary(s2[row][column]);
						break;
					case 2:
						currentS = Utils.decimalToBinary(s3[row][column]);
						break;
					case 3:
						currentS = Utils.decimalToBinary(s4[row][column]);
						break;
					case 4:
						currentS = Utils.decimalToBinary(s5[row][column]);
						break;
					case 5:
						currentS = Utils.decimalToBinary(s6[row][column]);
						break;
					case 6:
						currentS = Utils.decimalToBinary(s7[row][column]);
						break;
					case 7:			
						currentS = Utils.decimalToBinary(s8[row][column]);
						break;
					default:
						break;
				}
				currentS = Utils.padsBinaryToSize((currentS), 4);
				System.out.println("s" + i+1 + "["+row+"] ["+column+"] = " + currentS + "");
				s = s + currentS;
		}

			//convert b[i][1]b[i][2]b[i]30]b[i][4] into a decimal column
			//transform si[row][column] into a binary number of 4 bits
			//compute S by merging s1(b[0])...s8(b[7])
			

			//------------------------------------------------------------------
			//note that each item s1(b[0])...s8(b[7]) should be of 4 bit and padded
			//with zeros at the beginning if the bits are less than 4
			//------------------------------------------------------------------
			
			//compute f(Rn-1,Kn) by permuting S using p
			for (int i = 0; i < p.length; i++) {
				//	fn = fn + ...;
				fn = fn + s.charAt(p[i]-1);
			}
			Rn = Utils.computeXOR(Ln_minus_1,fn);
			System.out.println(Rn);
			Ln_minus_1 = Ln;
			Rn_minus_1 = Rn;
	//------------------------------
			
			//System.out.println(xor);
		}
		//merge R16 and L16 (R16 first)
		// Apply Final Permutation FP
		String mergedCiph = Rn+Ln;
		//String ciphertext = "";
		for (int i = 0; i < FP.length; i++) {
			ciphertext = ciphertext + mergedCiph.charAt((FP[i]-1));			
		}
		System.out.println(ciphertext);
		return ciphertext;
	}	
}
