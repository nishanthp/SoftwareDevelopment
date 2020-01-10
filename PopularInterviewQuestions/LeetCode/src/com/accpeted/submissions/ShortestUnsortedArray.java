package com.accpeted.submissions;

import java.util.Arrays;

public class ShortestUnsortedArray {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int findUnsortedSubarray(int[] nums) {
		int[] unsorted = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums);
		int end = 0;
		int start = nums.length;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != unsorted[i]) {
				start = Math.min(start, i);
				end = Math.max(end, i);
			}
		}
		return end - start > 0 ? end - start + 1 : 0;
	}

}
