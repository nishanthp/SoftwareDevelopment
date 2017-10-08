package newSet;

public class DriverlessCarDemo {
	public static void main(String[] args) {
		// grid size
		int n = 3;
		System.out.println(countPaths(n - 1, n - 1));
	}

	private static int countPaths(int i, int j) {
		if (i == 0 && j == 0) {
			return 1;
		}
		if (i < 0 || j < 0) {
			return 0;
		}
		if (i < j) {
			return 0;
		}

		return countPaths(i - 1, j) + countPaths(i, j - 1);
	}

}
