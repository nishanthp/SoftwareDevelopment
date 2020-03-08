package com.accpeted.submissions;

public class BalancedStrings {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int balancedStringSplit(String s) {
		int balanced = 0;
		int currentCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'L')
				currentCount++;
			else if (s.charAt(i) == 'R')
				currentCount--;
			if (currentCount == 0)
				balanced += 1;
		}
		return balanced;
	}

}
