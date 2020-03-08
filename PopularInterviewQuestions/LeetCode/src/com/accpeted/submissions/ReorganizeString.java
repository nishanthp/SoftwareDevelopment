package com.accpeted.submissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public String reorganizeString(String S) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char e : S.toCharArray()) {
			int count = map.getOrDefault(e, 0) + 1;
			if (count > (S.length() + 1) / 2)
				return "";
			map.put(e, count);
		}
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(
				new Comparator<int[]>() {
					@Override
					public int compare(int[] n1, int[] n2) {
						return n2[1] - n1[1];
					}
				});

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			queue.offer(new int[]{(int) entry.getKey(), entry.getValue()});
		}

		StringBuffer sb = new StringBuffer();
		while (!queue.isEmpty()) {
			int[] first = queue.poll();
			System.out.println(first[0] + " " + first[1]);
			if (sb.length() == 0
					|| sb.toString().charAt(sb.length() - 1) != first[0]) {
				sb.append((char) first[0]);
			} else {
				int[] second = queue.poll();
				sb.append((char) second[0]).append((char) first[0]);
				if (--second[1] > 0)
					queue.offer(second);
			}
			if (--first[1] > 0)
				queue.offer(first);
		}
		return sb.toString();

	}

}
