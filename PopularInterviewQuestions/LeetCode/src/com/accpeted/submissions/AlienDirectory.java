package com.accpeted.submissions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class AlienDirectory {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	HashMap<Character, Integer> inDegree = new HashMap<Character, Integer>();
	HashMap<Character, Set<Character>> nextNeighbors = new HashMap<Character, Set<Character>>();
	public String alienOrder(String[] words) {
		if (words.length == 0 || words[0].length() == 0)
			return "";
		StringBuilder letterOrder = new StringBuilder();
		// populate indegree map.
		for (String word : words) {
			char[] curr = word.toCharArray();
			for (int i = 0; i < curr.length; i++) {
				inDegree.putIfAbsent(curr[i], 0);
			}
		}
		buildGraph(words);

		Queue<Character> queue = new LinkedList<Character>();
		for (Entry<Character, Integer> each : inDegree.entrySet()) {
			if (each.getValue() == 0)
				queue.add(each.getKey());
		}

		while (!queue.isEmpty()) {
			Character temp = queue.poll();
			letterOrder.append(temp.toString());
			for (Character next : nextNeighbors.getOrDefault(temp,
					new HashSet<Character>())) {
				if (!inDegree.containsKey(next))
					break;
				inDegree.put(next, inDegree.get(next) - 1);
				if (inDegree.get(next) == 0)
					queue.add(next);
			}
		}
		String res = letterOrder.toString();
		return res.length() == inDegree.size() ? res : "";
	}

	public void buildGraph(String[] words) {
		for (int i = 0; i < words.length - 1; i++) {
			String curr = words[i];
			String next = words[i + 1];
			int minLength = Math.min(curr.length(), next.length());
			for (int j = 0; j < minLength; j++) {
				char first = curr.charAt(j);
				char second = next.charAt(j);
				if (first != second) {
					Set<Character> temp = nextNeighbors.getOrDefault(first,
							new HashSet<Character>());
					if (!temp.contains(second)) {
						temp.add(second);
						inDegree.put(second, inDegree.get(second) + 1);
						nextNeighbors.put(first, temp);
					}
					break;
				}

			}
		}
	}

}
