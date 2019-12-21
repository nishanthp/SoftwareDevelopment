package com.accpeted.submissions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LargestNumber {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public String largestNumber(int[] nums) {
		PriorityQueue<String> queue = new PriorityQueue<String>(
				new Comparator<String>() {
					@Override
					public int compare(String n1, String n2) {
						String nG = n1 + n2;
						String nS = n2 + n1;
						return nS.compareTo(nG);
					}
				});
		for (int n : nums) {
			queue.offer(String.valueOf(n));
		}
		if (queue.peek().charAt(0) == '0')
			return "0";
		StringBuffer sb = new StringBuffer();
		while (!queue.isEmpty()) {
			sb.append(queue.remove());
		}
		return sb.toString();
	}

}
