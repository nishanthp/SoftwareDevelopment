package com.practice.arrays;

public class SortedMatrixSearchDemo {
	public static void main(String[] args) {
		int[][] input = { { 15, 20, 40, 85 }, { 20, 35, 80, 95 }, { 30, 55, 95, 105 }, { 40, 80, 100, 120 } };
		int element = 55;
		System.out.println(searchElementInMatrix(input, element));
		System.out.println(searchElementInMatrix_simple_way(input, element));
	}

	// without binary search.
	private static boolean searchElementInMatrix_simple_way(int[][] input, int element) {
		int row = 0;
		int colmn = input[0].length - 1;
		while (colmn >= 0 && row < input.length) {
			if (input[row][colmn] == element) {
				return true;
			} else if (input[row][colmn] > element) {
				colmn--;
			} else {
				row++;
			}
		}
		return false;
	}

	// with binary search.
	private static boolean searchElementInMatrix(int[][] input, int element) {
		for (int i = 0; i < input.length; i++) {
			if (binarySearch(input[i], 0, input[i].length - 1, element)) {
				return true;
			}
		}
		return false;
	}

	private static boolean binarySearch(int[] input, int startIndex, int endIndex, int element) {
		if (startIndex > endIndex) {
			return false;
		}
		int mid = (startIndex + endIndex) / 2;
		if (input[mid] == element) {
			return true;
		}

		if (input[mid] > element) {
			return binarySearch(input, startIndex, mid - 1, element);
		} else {
			return binarySearch(input, mid + 1, endIndex, element);
		}
	}

}
