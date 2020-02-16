package com.accpeted.submissions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int leastBricks(List<List<Integer>> wall) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (List<Integer> row : wall) {
			int sum = 0;
			for (int i = 0; i < row.size() - 1; i++) {
				sum += row.get(i);
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}

		int result = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			result = Math.max(result, entry.getValue());
		}
		return wall.size() - result;
	}

}
