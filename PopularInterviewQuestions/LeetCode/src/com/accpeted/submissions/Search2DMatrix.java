package com.accpeted.submissions;

public class Search2DMatrix {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int rowLength = matrix.length - 1;
		int colmnLength = matrix[0].length - 1;
		int rowIndex = 0;
		int columnIndex = matrix[0].length - 1;
		while (rowIndex <= rowLength && columnIndex >= 0) {
			if (matrix[rowIndex][columnIndex] > target)
				columnIndex -= 1;
			else if (matrix[rowIndex][columnIndex] < target)
				rowIndex += 1;
			else if (target == matrix[rowIndex][columnIndex]) {
				return true;
			}
		}
		return false;
	}
}
