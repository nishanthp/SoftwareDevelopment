package com.practice.arrays;

public class CountNumberofIslandsDemo {
	int ROW = 5;
	int COL = 5;

	public static void main(String[] args) {
		int[][] m = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
		CountNumberofIslandsDemo islands = new CountNumberofIslandsDemo();
		int numberofIslands = islands.countIslands(m);
		System.out.println(numberofIslands);
	}

	public int countIslands(int[][] m) {
		int count = 0;
		boolean[][] visited = new boolean[5][5];

		// traverse the array.
		for (int i = 0; i < ROW; ++i) {
			for (int j = 0; j < COL; ++j) {
				if (m[i][j] == 1 && !visited[i][j]) {
					Dfs(m, i, j, visited);
					++count;
				}

			}
		}

		return count;
	}

	private void Dfs(int[][] m, int i, int j, boolean[][] visited) {
		visited[i][j] = true;
		// search all the 8 neighbors.
		int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };
		for (int k = 0; k < 8; ++k) {
			if (isSafe(m, i + row[k], j + col[k], visited)) {
				Dfs(m, i + row[k], j + col[k], visited);
			}
		}

	}

	private boolean isSafe(int[][] m, int i, int j, boolean[][] visited) {
		return (i >= 0) && (j >= 0) && (i < ROW) && (j < COL) && (!visited[i][j]) && (m[i][j] == 1);
	}
}
