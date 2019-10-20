package com.accpeted.submissions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	List<List<Integer>> result = new LinkedList<>();
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		HashMap<Integer, List<Integer>> allPaths = new HashMap<Integer, List<Integer>>();
		for (int i = 0; i < graph.length; i++) {
			List<Integer> temp = allPaths.getOrDefault(i,
					new LinkedList<Integer>());
			for (int j = 0; j < graph[i].length; j++) {
				temp.add(graph[i][j]);
			}
			allPaths.put(i, temp);
		}
		List<Integer> currPath = new LinkedList<Integer>();
		// source node.
		dfs(allPaths, 0, currPath);
		return result;
	}

	public void dfs(HashMap<Integer, List<Integer>> allPaths, int key,
			List<Integer> currNeighnors) {
		if (allPaths.get(key) == null || allPaths.get(key).size() == 0) {
			List<Integer> temp = new LinkedList<Integer>();
			temp.addAll(currNeighnors);
			result.add(temp);
			return;
		}
		if (!currNeighnors.contains(key))
			currNeighnors.add(key); // add source node.
		for (Integer curKey : allPaths.getOrDefault(key,
				new LinkedList<Integer>())) {
			currNeighnors.add(curKey);
			dfs(allPaths, curKey, currNeighnors);
			currNeighnors.remove(currNeighnors.size() - 1);
		}
		return;
	}

}
