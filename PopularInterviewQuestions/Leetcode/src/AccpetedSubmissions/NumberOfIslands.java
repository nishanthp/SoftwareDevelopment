package AccpetedSubmissions;

public class NumberOfIslands {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	char[][] grid;
	boolean[][] visited;

	public int numIslands(char[][] grid) {
		this.grid = grid;
		if (grid.length == 0)
			return 0;
		visited = new boolean[grid.length][grid[0].length];
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (!visited[i][j] && grid[i][j] == '1') {
					count += 1;
					island(i, j);
				}
			}
		}
		return count;
	}

	public void island(int i, int j) {
		int rowLength = grid.length - 1;
		int colmnLength = grid[0].length - 1;
		if (i < 0 || j < 0 || i > rowLength || j > colmnLength || visited[i][j] || grid[i][j] == '0')
			return;
		visited[i][j] = true;
		island(i + 1, j);
		island(i, j + 1);
		island(i - 1, j);
		island(i, j - 1);
		return;
	}
}
