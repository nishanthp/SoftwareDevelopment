package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Cannot use priorityQueue. Normal bfs will suffice.
	public int shortestDistance(int[][] grid) {
		int[][] reachable = new int[grid.length][grid[0].length];
		int[][] totalDistance = new int[grid.length][grid[0].length];
		int minDistance = Integer.MAX_VALUE;
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					bfs(grid, i, j, reachable, totalDistance);
					count++;
				}

			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (reachable[i][j] == count && grid[i][j] == 0) {
					minDistance = Math.min(minDistance, totalDistance[i][j]);
				}
			}
		}
		return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
	}

	public void bfs(int[][] grid, int i, int j, int[][] reachable,
			int[][] totalDistance) {
		Queue<int[]> queue = new LinkedList<int[]>();
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		queue.add(new int[]{i, j});
		visited[i][j] = true;
		int currDistance = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			currDistance += 1;
			for (int k = 0; k < size; k++) {
				int[] curr = queue.poll();
				int x = curr[0];
				int y = curr[1];
				if (x > 0 && !visited[x - 1][y] && grid[x - 1][y] == 0) {
					queue.add(new int[]{x - 1, y});
					reachable[x - 1][y] += 1;
					totalDistance[x - 1][y] += currDistance;
					visited[x - 1][y] = true;
				}
				if (y > 0 && !visited[x][y - 1] && grid[x][y - 1] == 0) {
					queue.add(new int[]{x, y - 1});
					reachable[x][y - 1] += 1;
					totalDistance[x][y - 1] += currDistance;
					visited[x][y - 1] = true;
				}
				if (x < grid.length - 1 && !visited[x + 1][y]
						&& grid[x + 1][y] == 0) {
					queue.add(new int[]{x + 1, y});
					reachable[x + 1][y] += 1;
					totalDistance[x + 1][y] += currDistance;
					visited[x + 1][y] = true;
				}
				if (y < grid[0].length - 1 && !visited[x][y + 1]
						&& grid[x][y + 1] == 0) {
					queue.add(new int[]{x, y + 1});
					reachable[x][y + 1] += 1;
					totalDistance[x][y + 1] += currDistance;
					visited[x][y + 1] = true;
				}
			}
		}
	}

}
