package com.accpeted.submissions;

public class GrumpyBookStoreOwner {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int i = 0;
		int grumpySum = 0;
		int nonGrumpySum = 0;
		int maxGrumpy = 0;
		while (i < customers.length) {
			if (i - X >= 0 && grumpy[i - X] == 1) {
				grumpySum -= customers[i - X];
			}
			if (grumpy[i] == 0) {
				nonGrumpySum += customers[i];
			} else {
				grumpySum += customers[i];
				maxGrumpy = Math.max(maxGrumpy, grumpySum);
			}
			i++;
		}

		return nonGrumpySum + maxGrumpy;
	}

}
