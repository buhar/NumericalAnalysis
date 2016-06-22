package matrixEncryption;

public class MatrixEncryption {
	public static void main(String[] args) {
		
		String txt2matrix = "Alan Turing Enigma";
		int[][] matrix2txt = {{213,235,213,239},{251,253,247,229},{239,225,221,239},{229,225,237,213}};
		
		encrypt(txt2matrix);
		decrypt(matrix2txt);
		
	}
	
	public static void encrypt(String plainText) {
		String text = plainText;
		text = text.replace(" ", "");
		text = text.toLowerCase();
		
		
		String[][] array = new String[4][4];
		int index = 0;
		
		for (int i=0; i<4; i++) {
			System.out.print("[");
			for (int j=0; j<4; j++) {
				if (index < text.length()) {
					int number = (int)text.charAt(index) * 2 + 19;
					array[i][j] = Integer.toString(number);
					index++;
				} else {
					array[i][j] = "0";
					index++;
				}
				System.out.print(" " + array[i][j]);
			}
			System.out.println(" ]");
		}
		System.out.println();
	}
	
	public static void decrypt(int[][] arrayNumbers) {
		int[][] n = arrayNumbers;
		char[][] output = new char[4][4];
		
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				int b = (n[i][j] - 19)/2;
				output[i][j] = (char)b;
				System.out.print(output[i][j]);
			}
		}
	}
}