package com.accpeted.submissions;

import java.util.Arrays;

public class FirstMissingPositive {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int firstMissingPositive(int[] nums) {
		int firstPositive = 1;
		if (nums.length == 0)
			return firstPositive;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0)
				continue;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			if (nums[i] == firstPositive) {
				firstPositive += 1;
				continue;
			}
			return firstPositive;
		}
		return nums[nums.length - 1] < 0
				? firstPositive
				: nums[nums.length - 1] + 1;
	}

}
