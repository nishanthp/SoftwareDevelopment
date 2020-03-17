package com.accpeted.submissions;

import java.util.PriorityQueue;

public class MinCostToConnectSticks {

	public static void main(String[] args) {
		// Ran on leetcode.
		String n1 = "abj";
		System.out.println(n1.contains("j"));

	}

	public int connectSticks(int[] sticks) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int result = 0;
		for (int stick : sticks) {
			pq.offer(stick);
		}

		while (pq.size() > 1) {
			int curr = pq.poll() + pq.poll();
			result += curr;
			pq.offer(curr);
		}
		return result;
	}

}
