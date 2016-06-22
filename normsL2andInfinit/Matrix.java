package normsL2andInfinit;

import javax.swing.JOptionPane;

public class Matrix {
	public static void main(String[] args) {
		double[][] m = initMatrix(matrix());
		
		double infinitMatrixNorm = normaInfinit(m);
		double frobenius = Frobenius(m);
		
		System.out.println("Norma Infinit e matrices m eshte: " + infinitMatrixNorm);
		System.out.println("Norma Frobenius e matrices m eshte: " + frobenius);
	}

	// caktimi i rendit te matrices
	public static double[][] matrix() {
		int i = new Integer(JOptionPane.showInputDialog("Shtyp rendin e matrices")).intValue();
		double[][] matrix = new double[i][i];
		return matrix;
	}

	// inicializimi i matrices
	public static double[][] initMatrix(double[][] m) {
		double[][] matrix = m;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				matrix[i][j] = new Double(JOptionPane.showInputDialog("Shtype elementin " + i + " " + j)).doubleValue();
			}
		}
		return matrix;
	}

	// Infinit norma matricore
	public static double normaInfinit(double[][] x) {
		double max = 0;
		for (int i = 0; i < x.length; i++) {
			double sum = 0;
			for (int j = 0; j < x.length; j++) {
				sum = sum + Math.abs(x[i][j]);
			}
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}

	// printimi i matrices
	public static void printMatrix(double[][] x) {
		double[][] t = x;
		for (int i = 0; i < x.length; i++) {
			System.out.print("");
			for (int j = 0; j < x.length; j++) {
				System.out.print(" " + t[i][j]);
			}
			System.out.println();
		}
	}
	
	// Frobenius
	public static double Frobenius(double[][] f) {
		double[][] matrix = f;
		double sum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				sum = sum + Math.pow(matrix[i][j], 2);
			}
		}
		return Math.sqrt(sum);
	}	
}