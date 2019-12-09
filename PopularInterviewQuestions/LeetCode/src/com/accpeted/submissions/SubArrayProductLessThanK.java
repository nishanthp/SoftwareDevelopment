package com.accpeted.submissions;

import java.util.concurrent.CountDownLatch;

public class SubArrayProductLessThanK {

	public static void main(String[] args) {
		// Ran on leetcode.
		CountDownLatch l1 = new CountDownLatch(1);
		l1.countDown();

	}

	public int numSubarrayProductLessThanK(int[] nums, int k) {
		if (k == 0)
			return 0;
		int left = 0;
		int right = left;
		int count = 0;
		int currProd = 1;
		while (right < nums.length) {
			currProd *= nums[right];
			right++;
			while (left < nums.length && currProd >= k) {
				currProd = currProd / nums[left];
				left++;
			}
			count += right - left;
		}
		return count <= 0 ? 0 : count;
	}

}
