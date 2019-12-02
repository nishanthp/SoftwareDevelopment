package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CriticalConnectionsInNetwork {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	List<List<Integer>> result = new ArrayList<>();
	public List<List<Integer>> criticalConnections(int n,
			List<List<Integer>> connections) {
		int[] distance = new int[n];
		int[] lowestDistance = new int[n];
		int time = 0;
		HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
		int[] parent = new int[n];
		Arrays.fill(parent, -1);
		boolean[] visited = new boolean[n];

		for (List<Integer> connection : connections) {
			graph.putIfAbsent(connection.get(0), new ArrayList<Integer>());
			graph.putIfAbsent(connection.get(1), new ArrayList<Integer>());
			graph.get(connection.get(0)).add(connection.get(1));
			graph.get(connection.get(1)).add(connection.get(0));
		}
		dfs(0, graph, distance, lowestDistance, parent, time, visited);
		return result;
	}

	private void dfs(int root, HashMap<Integer, List<Integer>> graph,
			int[] distance, int[] lowestDistance, int[] parent, int time,
			boolean[] visited) {
		if (visited[root])
			return;
		visited[root] = true;
		distance[root] = time;
		lowestDistance[root] = time;
		time++;
		for (int neighbor : graph.get(root)) {
			if (!visited[neighbor]) {
				parent[neighbor] = root;
				dfs(neighbor, graph, distance, lowestDistance, parent, time,
						visited);
				lowestDistance[root] = Math.min(lowestDistance[root],
						lowestDistance[neighbor]);
				if (distance[root] < lowestDistance[neighbor]) {
					List<Integer> temp = new ArrayList<Integer>();
					temp.add(root);
					temp.add(neighbor);
					result.add(temp);
				}
			} else if (parent[root] != neighbor) {
				lowestDistance[root] = Math.min(lowestDistance[root],
						distance[neighbor]);
			}
		}
		return;
	}

}
