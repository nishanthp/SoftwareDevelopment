package com.accpeted.submissions;

public class UniquePaths2 {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		boolean[][] map = new boolean[m][n];
		int[][] count = new int[m][n];
		return uniquePathsRob(m - 1, n - 1, obstacleGrid, count, map);
	}

	public int uniquePathsRob(int row, int colmn, int[][] obstacleGrid, int[][] count, boolean[][] map) {
		if (row < 0 || colmn < 0)
			return 0;
		if (obstacleGrid[row][colmn] == 1)
			return 0;
		if (row == 0 && colmn == 0)
			return 1;
		if (map[row][colmn]) {
			return count[row][colmn];
		}
		map[row][colmn] = true;
		return count[row][colmn] = (uniquePathsRob(row - 1, colmn, obstacleGrid, count, map)
				+ uniquePathsRob(row, colmn - 1, obstacleGrid, count, map));
	}
}
