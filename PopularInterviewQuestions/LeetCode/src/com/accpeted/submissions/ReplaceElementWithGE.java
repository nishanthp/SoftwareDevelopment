package com.accpeted.submissions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ReplaceElementWithGE {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int[] replaceElements(int[] arr) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer n1, Integer n2) {
						return n2 - n1;
					}
				});
		int[] result = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			if (queue.isEmpty()) {
				result[i] = -1;
			}
			if (!queue.isEmpty())
				result[i] = queue.peek();
			else
				result[i] = -1;
			queue.offer(arr[i]);
		}
		return result;
	}

}
