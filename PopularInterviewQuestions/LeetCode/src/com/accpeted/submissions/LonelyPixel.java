package com.accpeted.submissions;

public class LonelyPixel {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public int findLonelyPixel(char[][] picture) {
		int count = 0;
		for (int i = 0; i < picture.length; i++) {
			for (int j = 0; j < picture[0].length; j++) {
				if (picture[i][j] == 'B') {
					if (isLonelyPixel(picture, i, j))
						count += 1;
				}
			}
		}
		return count;
	}

	public boolean isLonelyPixel(char[][] picture, int x, int y) {
		for (int row = 0; row < picture.length; row++) {
			if (row == x)
				continue;
			if (picture[row][y] == 'B')
				return false;
		}
		for (int col = 0; col < picture[0].length; col++) {
			if (col == y)
				continue;
			if (picture[x][col] == 'B')
				return false;;
		}
		return true;
	}

}
