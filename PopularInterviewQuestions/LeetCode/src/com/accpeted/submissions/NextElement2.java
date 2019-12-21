package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextElement2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// A good question.
	public int[] nextGreaterElements(int[] nums) {
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int[] result = new int[nums.length];
		for (int i = 2 * nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[i % nums.length] >= stack.peek())
				stack.pop();
			if (stack.isEmpty()) {
				result[i % nums.length] = -1;
			} else {
				result[i % nums.length] = stack.peek();
			}
			stack.push(nums[i % nums.length]);
		}
		return result;
	}

}
