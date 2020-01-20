package com.accpeted.submissions;

import java.util.Arrays;

public class ThreeSumSmaller {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int threeSumSmaller(int[] nums, int target) {
		int count = 0;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum >= target) {
					end--;
				} else {
					count += end - start;
					start++;
				}
			}
		}
		return count;
	}

}
