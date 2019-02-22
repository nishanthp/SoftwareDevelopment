package com.revision.nthTime;

import java.util.LinkedList;
import java.util.List;

public class LongestSnake {
	static int maxLength = 0;
	static List<Integer> result = new LinkedList<Integer>();
	public static void main(String[] args) {
		int[][] grid = {{7,8,41}, {10,9,29}, {11,22,32}};
		findLongestSnake(grid);
	}

	private static void findLongestSnake(int[][] grid) {
		boolean[][]visited = new boolean[grid.length][grid[0].length];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				List<Integer> path = new LinkedList<Integer>();
				if (!visited[i][j]) {
					//System.out.println(grid[i][j]);
					path = dfs(grid, visited, i, j, path, 0);
					//System.out.println(path.size());
					if(maxLength < path.size()) {
						//System.out.println(path.size());
						maxLength = path.size();
						result.clear();
						result.addAll(path);
					}
					visited[i][j] = true;
					};
			}
		}
		for(int p:result) {
			System.out.print(p);
		}
	}

	private static List<Integer> dfs(int[][] grid, boolean[][] visited, int row, int col, List<Integer> path, int start) {
	//System.out.println(row+ ""+ col);
	if(row <0 || row >= grid.length-1 || col<0 || col >=grid[0].length-1) return path;
	//System.out.println(row+ ""+ col);
	if(visited[row][col]) return path;
	//System.out.println(row+ ""+ col);
	visited[row][col] = true;
	path.add(grid[row][col]);
	if(Math.abs(grid[row][col]-grid[row+1][col]) == 1 ) {
		 dfs(grid, visited, row+1, col, path, start++);
	}
	if(Math.abs(grid[row][col]-grid[row][col+1]) == 1) {
		 dfs(grid, visited, row, col+1, path, start++);
	}
	visited[row][col] = false;
	return path;
	}

}
