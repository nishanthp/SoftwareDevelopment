package com.accpeted.submissions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SentenceSimilarity2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean areSentencesSimilarTwo(String[] words1, String[] words2,
			List<List<String>> pairs) {
		if (words1 == null && words2 == null)
			return true;
		if (words1 == null || words2 == null)
			return false;
		if (words1.length != words2.length)
			return false;

		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for (List<String> pair : pairs) {
			map.putIfAbsent(pair.get(0), new LinkedList<String>());
			map.putIfAbsent(pair.get(1), new LinkedList<String>());
			map.get(pair.get(0)).add(pair.get(1));
			map.get(pair.get(1)).add(pair.get(0));
		}
		for (int i = 0; i < words1.length; i++) {
			if (!words1[i].equals(words2[i])) {
				List<String> t1 = map.getOrDefault(words1[i], null);
				List<String> t2 = map.getOrDefault(words2[i], null);
				if (t1 == null || t2 == null)
					return false;
				if (!t1.contains(words2[i]) || !t2.contains(words1[i])) {
					Set<String> visited = new HashSet<String>();
					if (!dfs(map, words1[i], words2[i], visited))
						return false;
				}
			}
		}
		return true;
	}

	private boolean dfs(Map<String, List<String>> map, String key, String word,
			Set<String> visited) {
		if (map.get(key) == null)
			return false;
		if (visited.contains(key))
			return false;
		visited.add(key);
		for (String neighbor : map.get(key)) {
			if (neighbor.equals(word))
				return true;
			if (dfs(map, neighbor, word, visited))
				return true;
		}
		return false;
	}

}
