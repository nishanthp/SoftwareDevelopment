package com.accpeted.submissions;

import java.util.HashMap;

public class DominoPairs {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int numEquivDominoPairs(int[][] dominoes) {
		int count = 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int[] dominoe : dominoes) {
			int small = Math.min(dominoe[0], dominoe[1]);
			int large = Math.max(dominoe[0], dominoe[1]);
			String key = small + "$" + large;
			count += map.getOrDefault(key, 0);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		return count;
	}

}
