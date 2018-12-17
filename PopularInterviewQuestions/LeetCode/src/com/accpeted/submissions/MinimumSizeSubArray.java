package com.accpeted.submissions;

public class MinimumSizeSubArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	/**
	 * s = 7, nums = [2,3,4,2,1,3]
	 *
	 * 
	 */
	public int minSubArrayLen(int s, int[] nums) {
		int minSize = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				minSize = Math.min(minSize, (i + 1) - left);
				sum -= nums[left++];
			}
		}
		return minSize == Integer.MAX_VALUE ? 0 : minSize;
	}

}
