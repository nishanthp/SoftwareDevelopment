package com.accpeted.submissions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurances {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean uniqueOccurrences(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int each : arr) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (!set.add(entry.getValue()))
				return false;
		}
		return true;
	}

}
