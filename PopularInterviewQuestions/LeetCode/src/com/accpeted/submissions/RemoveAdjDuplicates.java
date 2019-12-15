package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAdjDuplicates {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public String removeDuplicates(String S) {
		Deque<Character> stack = new ArrayDeque<Character>();
		for (char curr : S.toCharArray()) {
			if (stack.isEmpty()) {
				stack.push(curr);
				continue;
			}
			if (stack.peek() == curr) {
				while (!stack.isEmpty() && stack.peek() == curr)
					stack.pop();
				continue;
			}
			stack.push(curr);

		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop() + "");
		}
		return sb.reverse().toString();
	}

}
