package normsL2andInfinit;
import javax.swing.JOptionPane;

public class Vector {
	public static void main(String[] args) {
		double[] v1 = initVector(vector());
		double[] v2 = initVector(vector());
		
		double normaL2 = normaL2(v1);
		double normaInfinit = normaInfinit(v1);
		double[] vectorDiference = vectorDiference(v1, v2);
		double euclideanDistance = normaL2(vectorDiference);
		double maximumDistance = normaInfinit(vectorDiference);
		
		System.out.println("Norma L2 e vektorit v1 eshte: " + normaL2);
		System.out.println("Norma Infinit e vektorit v1 eshte: " + normaInfinit);
		System.out.println("Distanca Euklideane e vektoreve v1 dhe v2 eshte: " + euclideanDistance);
		System.out.println("Distanca maksimale e vektoreve v1 dhe v2 eshte: " + maximumDistance);
	}
	
	// caktimi i gjatesise se vektorit
	public static double[] vector() {
		int i = new Integer(JOptionPane.showInputDialog("Shtyp gjatesine e vektorit")).intValue();
		double[] vector = new double [i];
		return vector;
	}
	
	// inicializimi i vektorit
	public static double[] initVector(double[] v) {
		double[] vector = v;
		for (int i = 0; i < vector.length; i++) {
			vector[i] = new Double(JOptionPane.showInputDialog("Shtype elementin " + i)).doubleValue();
		}
		return vector;
	}
	
	// L2 norma
	public static double normaL2(double[] x) {
		double t = 0;
		for (int i = 0; i < x.length; i++) {
			t = t + Math.pow(x[i], 2);
		}
		return Math.sqrt(t);
	}
	
	// Infinit norma
	public static double normaInfinit(double[] x) {
		double max = 0;
		for (int i = 0; i < x.length; i++) {
			if (Math.abs(x[i]) > max) {
				max = Math.abs(x[i]);
			}
		}
		return max;
	}
	
	// printimi i vektorit
	public static void printVector(double[] x) {
		double[] t = x;
		for (int i = 0; i < x.length; i++) {
			System.out.print(" " + t[i]);
		}
		System.out.println();
	}
	
	// ndryshimi i vektoreve
	public static double[] vectorDiference(double[] vector1, double[] vector2) {
		double[] diference = new double[vector1.length];
		if (vector1.length == vector2.length) {
			for (int i = 0; i < vector1.length; i++) {
				diference[i] = vector1[i] - vector2[i];
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nuk mund te zbriten dy vektore me gjatesi te ndryshme");
		}
		return diference;
	}	
}