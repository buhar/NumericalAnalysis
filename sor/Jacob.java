package sor;
/** 
 * @author Buhar
 * SOR
 * Detyra 5a) kapitulli 7.4
 */
public class Jacob {
	public static void main(String[] args) {
		double[][] A = {{10, -1, 2, 0, 6}, {-1, 11, -1, 3, 25}, {2, -1, 10, -1, -11}, {0, 3, -1, 8, 15}};
		double tol = 1E-3;
		int n0 = 40;
		double[] XO = {0, 0, 0, 0};
		double[] rez = jacob(A, tol, n0, XO);
		for (int i = 0; i < XO.length; i++) {
			System.out.println("x" + (i + 1) + " = " + rez[i]);
		}
	}

	public static double[] jacob(double[][] A, double tol, int n0, double[] XO) {
		int k = 1;
		double[] rez = new double[XO.length];
		try {
			while (k <= n0) {
				for (int i = 0; i < XO.length; i++) {
					double sum = 0;
					for (int j = 0; j <= i - 1; j++) {
						if (j != i) {
							sum = sum + A[i][j] * XO[j];
						} else {
							j++;
						}
					}
					rez[i] = (-sum + A[i][XO.length]) / A[i][i];

					if (Math.abs(normaInfinit(rez, XO)) < tol) {
						System.out.println("Numri i iterimeve: " + k);
						System.out.println("-----------------------");
						System.out.println(Math.abs(normaInfinit(rez, XO)));
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