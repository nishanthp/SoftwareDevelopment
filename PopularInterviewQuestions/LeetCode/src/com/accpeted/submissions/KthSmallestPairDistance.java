package com.accpeted.submissions;

import java.util.Arrays;

public class KthSmallestPairDistance {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int smallestDistancePair(int[] nums, int k) {
		// find the low and high.
		Arrays.sort(nums);
		int high = nums[nums.length - 1] - nums[0];
		int low = nums[1] - nums[0];

		for (int i = 0; i < nums.length - 1; i++) {
			low = Math.min(low, nums[i + 1] - nums[i]);
		}

		// We know low and high at this point, which serves as the range to
		// perform binary search.

		while (low < high) {
			int mid = (low + high) / 2;
			if (countPairs(nums, mid) < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	// Count all pairs in the array with difference <= mid.
	public int countPairs(int[] nums, int mid) {
		int count = 0;
		for (int left = 0; left < nums.length; left++) {
			int right = left;
			while (right < nums.length && (nums[right] - nums[left]) <= mid)
				right++;
			count += (right - left - 1);
		}

		return count;
	}

}
