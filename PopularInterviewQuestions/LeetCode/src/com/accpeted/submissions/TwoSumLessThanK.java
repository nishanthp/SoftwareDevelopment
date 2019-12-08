package com.accpeted.submissions;

import java.util.Arrays;

public class TwoSumLessThanK {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int twoSumLessThanK(int[] A, int K) {
		if (A.length < 2)
			return -1;
		int largestSmallestSum = Integer.MIN_VALUE;
		Arrays.sort(A);
		int left = 0;
		int right = A.length - 1;
		while (left < right) {
			int currVal = A[left] + A[right];
			if (currVal >= K)
				right--;
			else {
				largestSmallestSum = Math.max(largestSmallestSum,
						A[left] + A[right]);
				left++;
			}
		}
		return largestSmallestSum == Integer.MIN_VALUE
				? -1
				: largestSmallestSum;
	}

}
