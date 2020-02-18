package com.accpeted.submissions;

public class CountPrimes {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int countPrimes(int n) {
		int result = 0;
		boolean[] notprime = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (!notprime[i]) {
				result += 1;
				for (int j = 2; i * j < n; j++) {
					notprime[i * j] = true;
				}
			}
		}
		return result;
	}

}
