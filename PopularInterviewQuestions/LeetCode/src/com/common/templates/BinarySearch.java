package com.common.templates;

public class BinarySearch {

	public static void main(String[] args) {
		// 1. Index based.
		// 2. Value based.
		// 3. Binary search to terminate.
		int[] input = {1, 2, 4, 5};
		binarySearchIndexBased(input, 0, input.length, 4);
		binarySearchValueBased(input, 0, input.length, 4);
		binarySearchTerminate(input, 0, input.length);
	}

	private static int binarySearchIndexBased(int[] input, int low, int high,
			int target) {
		while (low <= high) {
			int mid = (low + high) / 2;
			if (mid == target)
				return input[mid];
			if (mid < target)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return -1;
	}

	private static int binarySearchValueBased(int[] input, int low, int high,
			int target) {
		while (low <= high) {
			int mid = (input[low] + input[high]) / 2;
			if (mid == target)
				return mid;
			if (mid < target)
				low = mid + 1;
			else
				high = mid - 1;

		}
		return -1;
	}

	// Can be used as variant of Random generator.
	private static int binarySearchTerminate(int[] input, int low, int high) {
		while (low < high) {
			int mid = (low + high) / 2;
			if (input[mid] > input[high])
				low = mid + 1;
			else
				high = mid;

		}
		return low;
	}

}
