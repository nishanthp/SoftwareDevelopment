package com.accpeted.submissions;

public class WallsAndGates {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public void wallsAndGates(int[][] rooms) {
		if (rooms.length == 0)
			return;
		boolean[][] visited = new boolean[rooms.length][rooms[0].length];
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0 && !visited[i][j]) {
					dfs(rooms, i, j, visited, 0);
				}
			}
		}
	}

	public void dfs(int[][] rooms, int i, int j, boolean[][] visited,
			int distance) {
		if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length
				|| rooms[i][j] == -1 || visited[i][j] || rooms[i][j] < distance)
			return;
		visited[i][j] = true;
		rooms[i][j] = Math.min(rooms[i][j], distance);
		dfs(rooms, i + 1, j, visited, distance + 1);
		dfs(rooms, i, j + 1, visited, distance + 1);
		dfs(rooms, i - 1, j, visited, distance + 1);
		dfs(rooms, i, j - 1, visited, distance + 1);
		visited[i][j] = false;
		return;
	}

}
