package com.accpeted.submissions;

public class CountOnes {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int hammingWeight(int n) {
		int total = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0)
				total += 1;
			mask <<= 1;
		}
		return total;
	}

}
