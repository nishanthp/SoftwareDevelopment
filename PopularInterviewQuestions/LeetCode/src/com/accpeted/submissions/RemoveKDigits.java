package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Array with stack.
	public String removeKdigits(String num, int k) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for (char curr : num.toCharArray()) {
			while (!stack.isEmpty() && k > 0 && stack.peek() > curr) {
				k--;
				stack.pop();
			}
			stack.push(curr);
		}

		for (int i = 0; i < k; i++) {
			stack.pop();
		}
		StringBuilder sb = new StringBuilder();
		boolean leadingZero = true;
		while (!stack.isEmpty()) {
			char curr = stack.removeLast();
			if (leadingZero && curr == '0')
				continue;
			leadingZero = false;
			sb.append(curr);
		}
		return sb.length() == 0 ? "0" : sb.toString();
	}

}
