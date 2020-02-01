package com.accpeted.submissions;

public class RangeSum2D {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	class NumMatrix {
		int[][] matrix;
		public NumMatrix(int[][] matrix) {
			this.matrix = matrix;
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			int sum = 0;
			if (row1 > row2 || col1 > col2)
				return -1;
			if (row1 < 0 || row2 < 0 || row1 > this.matrix.length - 1
					|| row2 > this.matrix.length - 1)
				return -1;
			if (col1 < 0 || col2 < 0 || col1 > this.matrix[0].length - 1
					|| col2 > this.matrix[0].length - 1)
				return -1;
			for (int i = row1; i <= row2; i++) {
				for (int j = col1; j <= col2; j++) {
					sum += this.matrix[i][j];
				}
			}
			return sum;
		}
	}

}
