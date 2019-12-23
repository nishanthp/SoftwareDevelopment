package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterNodeLL {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int[] nextLargerNodes(ListNode head) {
		Deque<Integer> stack1 = new ArrayDeque<Integer>();
		Deque<Integer> stack2 = new ArrayDeque<Integer>();

		while (head != null) {
			stack1.push(head.val);
			head = head.next;
		}
		int[] result = new int[stack1.size()];
		int i = stack1.size() - 1;
		while (!stack1.isEmpty()) {
			int curr = stack1.pop();
			while (!stack2.isEmpty() && stack2.peek() <= curr)
				stack2.pop();
			if (stack2.isEmpty()) {
				result[i--] = 0;
			} else {
				result[i--] = stack2.peek();
			}
			stack2.push(curr);
		}
		return result;
	}

}
