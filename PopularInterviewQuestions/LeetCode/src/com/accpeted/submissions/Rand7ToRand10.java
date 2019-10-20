package com.accpeted.submissions;

public class Rand7ToRand10 extends Solution {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int rand10() {
		int index = 0;
		do {
			int row = rand7();
			int col = rand7();
			index = (row - 1) * 7 + col;
		} while (index > 40);
		return 1 + (index % 10);
	}

}

class Solution {
	public int rand7() {
		return 0;
	}
}