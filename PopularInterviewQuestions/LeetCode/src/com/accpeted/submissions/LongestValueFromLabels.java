package com.accpeted.submissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LongestValueFromLabels {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted,
			int use_limit) {
		int result = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		PriorityQueue<Node> queue = new PriorityQueue<Node>(
				new Comparator<Node>() {
					public int compare(Node n1, Node n2) {
						return n2.value - n1.value;
					}
				});
		for (int i = 0; i < values.length; i++) {
			queue.offer(new Node(labels[i], values[i]));
		}

		while (num_wanted > 0 && !queue.isEmpty()) {
			Node curr = queue.poll();

			if (map.getOrDefault(curr.label, 0) < use_limit) {
				map.put(curr.label, map.getOrDefault(curr.label, 0) + 1);
				result += curr.value;
				num_wanted -= 1;
			}

		}
		return result;
	}

	class Node {
		int label;
		int value;
		Node(int l, int v) {
			this.label = l;
			this.value = v;
		}
	}

}
