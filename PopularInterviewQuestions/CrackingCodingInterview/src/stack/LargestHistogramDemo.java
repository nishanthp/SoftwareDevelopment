package stack;

import java.util.LinkedList;

public class LargestHistogramDemo {
	public static void main(String[] args) {
		int[] input = { 2, 1, 2 };
		int maxArea = findLargestRectangle(input);
		System.out.println(maxArea);

	}

	private static int findLargestRectangle(int[] input) {
		java.util.Deque<Integer> stack = new LinkedList<>();
		int area = -1;
		int maxArea = -1;
		int i;
		for (i = 0; i < input.length;) {
			if (stack.isEmpty() || input[stack.peekFirst()] <= input[i]) {
				stack.offerFirst(input[i++]);
			} else {
				int top = stack.pollFirst();

				if (stack.isEmpty()) {
					area = input[top] * i;
				} else {
					area = input[top] * (i - stack.peekFirst() - 1);
				}

				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		/*
		 * histogram is done. However the stack is not empty. A rectangle
		 * waiting to contribute to max area of a rectangle.
		 */
		while (!stack.isEmpty()) {
			int top = stack.pollFirst();

			if (stack.isEmpty()) {
				area = input[top] * i;
			} else {
				area = input[top] * (i - stack.peekFirst() - 1);
			}

			if (area > maxArea) {
				maxArea = area;
			}
		}

		return maxArea;
	}

}
