package com.accpeted.submissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int leastInterval(char[] tasks, int n) {
		Map<Character, Integer> charCount = new HashMap<Character, Integer>();
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
				new Comparator<Integer>() {
					@Override
					public int compare(Integer n1, Integer n2) {
						return n2 - n1;
					}
				});
		for (char task : tasks) {
			charCount.put(task, charCount.getOrDefault(task, 0) + 1);
		}

		for (Character each : charCount.keySet()) {
			queue.offer(charCount.get(each));
		}

		int currTime = 0;
		// Below code the best part.
		Map<Integer, Integer> countDown = new HashMap<Integer, Integer>();
		while (!queue.isEmpty() || !countDown.isEmpty()) {
			if (countDown.containsKey(currTime - n - 1)) {
				queue.offer(countDown.remove(currTime - n - 1));
			}
			if (!queue.isEmpty()) {
				int left = queue.poll() - 1;
				if (left > 0)
					countDown.put(currTime, left);
			}
			currTime += 1;
		}

		return currTime;
	}

}
