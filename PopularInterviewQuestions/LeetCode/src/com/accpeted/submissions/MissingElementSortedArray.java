package com.accpeted.submissions;

public class MissingElementSortedArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int missingElement(int[] nums, int k) {
		int low = 0;
		int high = nums.length - 1;
		int missingCount = missing(high, nums);
		if (k > missingCount)
			return nums[high] + k - missingCount;
		while (low < high) {
			int midIndex = (low + high) / 2;
			int count = 0;
			count = nums[midIndex] - nums[0] - (midIndex);
			if (count < k) {
				low = midIndex + 1;
			} else
				high = midIndex;
		}

		return nums[low - 1] + k - missing(low - 1, nums);
	}

	private int missing(int index, int[] nums) {
		return nums[index] - nums[0] - index;
	}

}
