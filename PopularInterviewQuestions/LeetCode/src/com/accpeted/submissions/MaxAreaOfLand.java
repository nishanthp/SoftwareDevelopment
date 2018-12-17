package com.accpeted.submissions;

public class MaxAreaOfLand {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	int[][] grid;
	boolean[][] visited;

	public int maxAreaOfIsland(int[][] grid) {
		this.grid = grid;
		visited = new boolean[grid.length][grid[0].length];
		int maxCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j]) {
					maxCount = Math.max(maxCount, maxArea(i, j));
				}
			}
		}
		return maxCount;
	}

	public int maxArea(int i, int j) {
		int rowLength = grid.length - 1;
		int colmnLength = grid[0].length - 1;
		if (i < 0 || j < 0 || i > rowLength || j > colmnLength || grid[i][j] == 0 || visited[i][j])
			return 0;
		visited[i][j] = true;
		return grid[i][j] + maxArea(i + 1, j) + maxArea(i, j + 1) + maxArea(i - 1, j) + maxArea(i, j - 1);
	}

	// TODO: Try iterative approach.

}
