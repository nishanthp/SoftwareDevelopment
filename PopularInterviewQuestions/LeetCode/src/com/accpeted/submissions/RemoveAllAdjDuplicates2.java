package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjDuplicates2 {

	public static void main(String[] args) {
		// Ran on leetcode.
		String s = "#767676";
		System.out.println(s.toUpperCase());

	}

	public String removeDuplicates(String s, int k) {
		Deque<Node> stack = new ArrayDeque<Node>();
		for (char curr : s.toCharArray()) {
			if (stack.isEmpty() || stack.peek().c != curr) {
				stack.push(new Node(curr, 1));
				continue;
			}
			if (!stack.isEmpty() && stack.peek().c == curr) {
				stack.peek().count += 1;
			}

			if (!stack.isEmpty() && stack.peek().count == k) {
				stack.pop();
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			while (stack.peek().count > 0) {
				sb.append(stack.peek().c + "");
				stack.peek().count--;
			}
			stack.pop();

		}
		return sb.reverse().toString();

	}

	class Node {
		char c;
		int count;
		Node(char c, int count) {
			this.c = c;
			this.count = count;
		}
	}

}
