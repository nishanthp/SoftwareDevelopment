package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int[] dailyTemperatures(int[] T) {
		Deque<Node> stack = new ArrayDeque<Node>();
		int[] result = new int[T.length];
		for (int i = T.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && T[i] >= stack.peek().num) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result[i] = 0;
			} else {
				System.out.println(stack.peek().index);
				result[i] = stack.peek().index - i;
			}
			stack.push(new Node(T[i], i));
		}
		return result;
	}

	class Node {
		int num;
		int index;
		Node(int num, int index) {
			this.num = num;
			this.index = index;
		}

	}
}
