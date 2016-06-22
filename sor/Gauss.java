package sor;
/** 
 * @author Buhar
 * SOR
 * Detyra 5a) kapitulli 7.4
 */
public class Gauss {
	public static void main(String[] args) {
		double[][] koeficienti = {{3, -1, 1, 1}, {3, 6, 2, 0}, {3, 3, 7, 4}};
		double tol = 1E-3;
		int n0 = 40;
		double[] XO = {0, 0, 0};
		double[] rez = sor(koeficienti, tol, n0, XO);
		for (int i = 0; i < XO.length; i++) {
			System.out.println("x" + (i + 1) + " = " + rez[i]);
		}
	}

	public static double[] sor(double[][] koeficienti, double tol, int n0, double[] XO) {
		int k = 1;
		double[] rez = new double[XO.length];
		try {
			while (k <= n0) {
				for (int i = 0; i < XO.length; i++) {
					double sum1 = 0;
					double sum2 = 0;
					for (int j = 0; j <= i - 1; j++) {
						sum1 = sum1 + koeficienti[i][j] * rez[j];
					}
					for (int j = i + 1; j < XO.length; j++) {
						sum2 = sum2 + koeficienti[i][j] * XO[j];
					}

					rez[i] = (-sum1 - sum2 + koeficienti[i][XO.length]) / koeficienti[i][i];

					if (Math.abs(normaInfinit(rez, XO)) < tol) {
						System.out.println("Numri i iterimeve: " + k);
						System.out.println("-----------------------");
						return rez;
					}
					XO[i] = rez[i];
				}
				k++;
			}
		} catch (RuntimeException e) {
			System.out.println("Detyra ka kaluar numrin maksimal te iterimeve");
		}
		return rez;
	}

	public static double normaInfinit(double[] rez, double[] x0) {
		double max = Math.abs(rez[0] - x0[0]);
		for (int i = 0; i < rez.length - 1; i++) {
			if (Math.abs(rez[i + 1] - x0[i + 1]) > max) {
				max = Math.abs(rez[i + 1] - x0[i + 1]);
			}
		}
		return max;
	}
}