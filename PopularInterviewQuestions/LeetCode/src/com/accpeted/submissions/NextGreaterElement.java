package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElement {

	public static void main(String[] args) {
		// Not run in leetcode.
		int[] input = {4, 5, 2, 25};
		for (int i : nextGreaterElememt(input)) {
			System.out.println(i);
		}
		N n = new N();
		n.name();
	}

	// Array with stack.
	public static int[] nextGreaterElememt(int[] input) {
		int[] result = new int[input.length];
		Deque<Integer> stack = new ArrayDeque<Integer>();
		for (int i = input.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && input[i] >= stack.peek()) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				result[i] = stack.peek();
			}
			stack.push(input[i]);
		}
		return result;

	}

}

class N {
	protected void name() {
		System.out.println("kgrnergnr");
	}
}
