package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class PlusOne {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int[] plusOne(int[] digits) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int carry = 0;
		for (int i = digits.length - 1; i >= 0; i--) {
			int currSum = digits[i];
			if (i == digits.length - 1) {
				currSum += 1;
			}
			if (carry == 1) {
				currSum += carry;
				carry = 0;
			}
			if (currSum >= 10) {
				carry = 1;
			}
			stack.push(currSum % 10);
		}
		if (carry == 1)
			stack.push(1);
		int[] res = new int[stack.size()];
		int j = 0;
		while (!stack.isEmpty()) {
			res[j++] = stack.pop();
		}
		return res;
	}

}
