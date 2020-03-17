package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestHistogram {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// A stack problem.
	public int largestRectangleArea(int[] heights) {
		if (heights.length == 0)
			return 0;
		Deque<Integer> stack = new ArrayDeque<Integer>();
		int maxArea = 0;
		int i = 0;
		while (i < heights.length) {
			while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
				int top = stack.pop();
				if (!stack.isEmpty()) {
					maxArea = Math.max(maxArea,
							heights[top] * (i - 1 - stack.peek()));
				} else {
					maxArea = Math.max(maxArea, heights[top] * (i));
				}
			}
			stack.push(i);
			i++;
		}

		while (!stack.isEmpty()) {
			int top = stack.pop();
			if (!stack.isEmpty()) {
				maxArea = Math.max(maxArea,
						heights[top] * (i - 1 - stack.peek()));
			} else {
				maxArea = Math.max(maxArea, heights[top] * (i));
			}
		}
		return maxArea;
	}

}
