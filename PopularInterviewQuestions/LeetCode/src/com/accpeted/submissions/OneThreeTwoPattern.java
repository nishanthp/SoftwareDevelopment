package com.accpeted.submissions;

public class OneThreeTwoPattern {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// There is a stack approach. Please go through it.
	public boolean find132pattern(int[] nums) {
		int i = Integer.MAX_VALUE;
		for (int j = 1; j < nums.length; j++) {
			i = Math.min(i, nums[j - 1]);
			for (int k = j + 1; k < nums.length; k++) {

				if (i < nums[k] && nums[k] < nums[j])
					return true;
			}
		}
		return false;
	}

}
