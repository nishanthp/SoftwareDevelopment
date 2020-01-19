package com.accpeted.submissions;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = nums[0] + nums[1] + nums[nums.length - 1];

		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[start] + nums[end] + nums[i];
				if (sum < target) {
					start++;
				} else {
					end--;
				}
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

}
