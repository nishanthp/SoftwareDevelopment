package accpetedSubmissions;

public class IslandPerimeter {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int islandPerimeter(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int maxperimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j]) {
					int count = islandPerimeter(grid, visited, 0, i, j);
					maxperimeter = Math.max(maxperimeter, count);
				}
			}

		}
		return maxperimeter;
	}

	public int islandPerimeter(int[][] grid, boolean[][] visited, int count, int i, int j) {
		int rowLength = grid.length;
		int colmnlength = grid[0].length;
		if (i >= rowLength || i < 0 || j < 0 || j >= colmnlength)
			return 1;
		if (visited[i][j])
			return 0;
		if (grid[i][j] == 0)
			return 1;
		visited[i][j] = true;
		count += islandPerimeter(grid, visited, count, i + 1, j) + islandPerimeter(grid, visited, count, i, j + 1)
				+ islandPerimeter(grid, visited, count, i - 1, j) + islandPerimeter(grid, visited, count, i, j - 1);
		return count;
	}
}
