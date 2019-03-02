package com.accpeted.submissions;

import java.util.HashMap;

public class ContiousSubArraySum {

	public static void main(String[] args) {
		// Ran on leetcode.
		int[] nums = { 0, 1, 0, 4, 0 };
		checkSubarraySum(nums, 0);

	}

	public static boolean checkSubarraySum(int[] nums, int k) {
		int sumSoFar = 0;
		HashMap<Integer, Integer> remainders = new HashMap<Integer, Integer>() {
			{
				put(0, -1);
			}
		};

		for (int i = 0; i < nums.length; i++) {
			sumSoFar += nums[i];
			if (k != 0)
				sumSoFar %= k;
			// Have seen this remainder more than once.
			if (remainders.get(sumSoFar) != null) {
				if (i - remainders.get(sumSoFar) > 1) {
					return true;
				}
			} else {
				remainders.put(sumSoFar, i);
			}
		}
		return false;
	}

}
