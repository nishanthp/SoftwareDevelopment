package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// important part is not using count variable. Updating the matrix itself to
	// get min count.
	public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid.length == 0 || grid[0][0] == 1)
			return -1;
		int[][] dirs = {{1, 0}, {0, 1}, {0, -1}, {-1, 0}, {1, 1}, {1, -1},
				{-1, 1}, {-1, -1}};
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[]{0, 0});
		grid[0][0] = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int[] curr = queue.poll();
				if (curr[0] == grid.length - 1 && curr[1] == grid[0].length - 1)
					return grid[grid.length - 1][grid[0].length - 1];
				for (int[] next : dirs) {
					int nx = curr[0] + next[0];
					int ny = curr[1] + next[1];
					if (nx < 0 || ny < 0 || nx > grid.length - 1
							|| ny > grid[0].length - 1 || grid[nx][ny] != 0)
						continue;
					grid[nx][ny] = 1 + grid[curr[0]][curr[1]];
					queue.add(new int[]{nx, ny});
				}
			}
		}
		return -1;
	}

}
