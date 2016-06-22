package newton;

public class Newton {

	public static void main(String[] args) {
		double[][] x0 = { { 0.1, 0, 0 }, { 0.1, 0, 0 }, { -0.1, 0, 0 } };
		double x[][] = newton(x0, 10E-10, 30);

		System.out.println("x1 = " + x[0][0]);
		System.out.println("x2 = " + x[1][0]);
		System.out.println("x3 = " + x[2][0]);
	}

	public static double[][] newton(double[][] x, double tol, int n) {
		int k = 0;
		while (k < n) {
			double[][] invJ = inversi(J(x[0][0], x[1][0], x[2][0]));
			double[][] y = prodhimi(invJ, F(x[0][0], x[1][0], x[2][0]));
			x = zbritja(x, y);
			double[] z = { y[0][0], y[1][0], y[2][0] };
			if (normaInfinit(z) < tol) {
				System.out.println("Metoda perfundoi pas " + k + " iterimeve");
				return x;
			}
			k++;
		}
		throw new RuntimeException("U tejkalua numri i iterimeve: " + n);
	}

	public static double[][] F(double x1, double x2, double x3) {
		double[][] f = { { 3.0 * x1 - Math.cos(x2 * x3) - 1.0 / 2 },
				{ Math.pow(x1, 2) - 81 * Math.pow(x2 + 0.1, 2) + Math.sin(x3) + 1.06 },
				{ Math.pow(Math.E, -x1 * x2) + 20 * x3 + (10 * Math.PI - 3) / 3.0 } };
		return f;
	}

	public static double[][] J(double x1, double x2, double x3) {
		double[][] derivative = { { 3, x3 * Math.sin(x2 * x3), x2 * Math.sin(x2 * x3) },
				{ 2 * x1, -162 * (x2 + 0.1), Math.cos(x3) },
				{ -x2 * Math.pow(Math.E, (-x1 * x2)), -x1 * Math.pow(Math.E, (-x1 * x2)), 20 } };
		return derivative;
	}

	public static double[][] prodhimi(double[][] a, double[][] b) {
		double[][] p = new double[a.length][b.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int t = 0; t < a[0].length; t++) {
					p[i][j] = p[i][j] + (a[i][t] * b[t][j]);
				}
			}
		}
		return p;
	}

	public static double[][] inversi(double[][] x) {
		double[][] inversi = new double[x.length][x.length];
		double determinanta = (x[0][0] * x[1][1] * x[2][2]) + (x[0][1] * x[1][2] * x[2][0])
				+ (x[1][0] * x[2][1] * x[0][2]) - (x[0][2] * x[1][1] * x[2][0]) - (x[1][2] * x[2][1] * x[0][0])
				- (x[1][1] * x[0][1] * x[2][2]);
		inversi[0][0] = (x[1][1] * x[2][2] - x[2][1] * x[1][2]) / determinanta;
		inversi[0][1] = (x[0][2] * x[2][1] - x[2][2] * x[0][1]) / determinanta;
		inversi[0][2] = (x[0][1] * x[1][2] - x[1][1] * x[0][2]) / determinanta;
		inversi[1][0] = (x[1][2] * x[2][0] - x[2][2] * x[1][0]) / determinanta;
		inversi[1][1] = (x[0][0] * x[2][2] - x[2][0] * x[0][2]) / determinanta;
		inversi[1][2] = (x[0][2] * x[1][0] - x[1][2] * x[0][0]) / determinanta;
		inversi[2][0] = (x[1][0] * x[2][1] - x[2][0] * x[1][1]) / determinanta;
		inversi[2][1] = (x[0][1] * x[2][0] - x[2][1] * x[0][0]) / determinanta;
		inversi[2][2] = (x[0][0] * x[1][1] - x[1][0] * x[0][1]) / determinanta;

		return inversi;
	}

	public static double[][] zbritja(double[][] a, double[][] b) {
		double[][] m = new double[a.length][a.length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				m[i][j] = a[i][j] - b[i][j];
			}
		}
		return m;
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
}