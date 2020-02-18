package com.accpeted.submissions;

public class IsUgly {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean isUgly(int num) {
		if (num == 0)
			return false;
		for (int i = 2; i <= 5; i++) {
			if (i == 4)
				continue;
			while (num % i == 0) {
				num = num / i;
			}
		}
		return num == 1;
	}

}
