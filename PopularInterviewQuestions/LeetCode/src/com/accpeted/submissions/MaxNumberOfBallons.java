package com.accpeted.submissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxNumberOfBallons {

	public static void main(String[] args) {
		// Ran on leetcode.
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(
				new Comparator<int[]>() {

					@Override
					public int compare(int[] o1, int[] o2) {
						// TODO Auto-generated method stub
						return 0;
					}

				});

	}

	public int maxNumberOfBalloons(String text) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		String input = "balon";

		for (char c : text.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int minCount = Integer.MAX_VALUE;
		for (char c : input.toCharArray()) {
			if (map.getOrDefault(c, 0) == 0 || map.getOrDefault('l', 0) < 2
					|| map.getOrDefault('o', 0) < 2)
				return 0;
			if (c == 'l') {
				int lCount = map.get(c) / 2;
				minCount = Math.min(minCount, lCount);
			} else if (c == 'o') {
				int oCount = map.get(c) / 2;
				minCount = Math.min(minCount, oCount);
			} else {
				int uCount = map.get(c);
				minCount = Math.min(minCount, uCount);
			}

		}
		return minCount;
	}

}
