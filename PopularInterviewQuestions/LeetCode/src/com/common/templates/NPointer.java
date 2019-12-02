package com.common.templates;

import java.util.Arrays;

public class NPointer {

	public static void main(String[] args) {
		// 1. 2-pointer
		// 2. 3-pointer
		// 3. 4-pointer
		int[] input = {1, 2, 44, 66};
		int targetSum = 100;
		Arrays.sort(input); // needs to be sorted.
		twoArraySolution(input, 0, input.length, targetSum);
	}

	private static int[] twoArraySolution(int[] input, int low, int high,
			int target) {
		while (low < high) {
			int curr_sum = input[low] + input[high];
			if (curr_sum == target)
				return new int[]{low, high};
			if (curr_sum < target)
				low++;
			else
				high++;
		}
		return new int[]{-1, -1};
	}
}
