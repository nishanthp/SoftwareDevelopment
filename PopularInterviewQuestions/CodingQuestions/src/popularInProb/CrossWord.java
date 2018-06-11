package popularInProb;

import java.util.DoubleSummaryStatistics;

public class CrossWord {
	static Boolean doesitExist = false;

	public static void main(String[] args) {
		char[][] grid = new char[3][4];
		grid[0][0] = 'G';
		grid[0][1] = 'E';
		grid[0][2] = 'E';
		grid[0][3] = 'K';
		grid[1][0] = 'S';
		grid[1][1] = 'E';
		grid[1][2] = 'E';
		grid[1][3] = 'I';
		grid[2][0] = 'K';
		grid[2][1] = 'E';
		grid[2][2] = 'I';
		grid[2][3] = 'N';
		String word = "GEEK";
		CrossWord cw = new CrossWord();
		cw.searchforAWord(grid, word);
		System.out.println("" + doesitExist);
	}

	public boolean searchforAWord(char[][] grid, String word) {
		int m = grid.length;
		int n = grid[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				doesitExist = search(grid, word, i, j, 0);
				if(doesitExist)
					return doesitExist;
			}
		}
		return doesitExist;
	}

	private boolean search(char[][] grid, String word, int i, int j, int k) {
		int m = grid.length;
		int n = grid[0].length;
		if (i < 0 || j < 0 || i >= m || j >= n) {
			return false;
		}

		if (grid[i][j] == word.charAt(k)) {

			if (k == word.length() - 1) {
				return true;
			} else if (search(grid, word, i + 1, j, k + 1) || search(grid, word, i, j + 1, k + 1)
					|| search(grid, word, i - 1, j, k + 1) || search(grid, word, i, j - 1, k + 1)
					|| search(grid, word, i - 1, j - 1, k + 1) || search(grid, word, i + 1, j + 1, k + 1)
					|| search(grid, word, i + 1, j - 1, k + 1) || search(grid, word, i - 1, j + 1, k + 1)) {
				return true;
			}
		}
		return false;
	}
}
