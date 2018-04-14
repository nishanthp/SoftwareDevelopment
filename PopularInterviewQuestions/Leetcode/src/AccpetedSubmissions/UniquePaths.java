package AccpetedSubmissions;

public class UniquePaths {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int uniquePaths(int m, int n) {
		boolean[][] map = new boolean[m][n];
		int[][] count = new int[m][n];
		return uniquePathsRob(m - 1, n - 1, count, map);
	}

	public int uniquePathsRob(int row, int colmn, int[][] count, boolean[][] map) {
		if (row == 0 && colmn == 0)
			return 1;
		if (row < 0 || colmn < 0)
			return 0;
		if (map[row][colmn]) {
			return count[row][colmn];
		}
		map[row][colmn] = true;
		return count[row][colmn] = (uniquePathsRob(row - 1, colmn, count, map)
				+ uniquePathsRob(row, colmn - 1, count, map));
	}
}
