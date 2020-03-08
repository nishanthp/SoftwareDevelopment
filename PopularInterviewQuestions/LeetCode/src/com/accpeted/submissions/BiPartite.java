package com.accpeted.submissions;

public class BiPartite {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean isBipartite(int[][] graph) {
		int n = graph.length;
		int[] colors = new int[n];

		for (int i = 0; i < n; i++) {
			if (colors[i] == 0 && !validGraph(graph, colors, i, 1))
				return false;
		}
		return true;
	}

	private boolean validGraph(int[][] graph, int[] colors, int curr,
			int currColor) {
		if (colors[curr] != 0) {
			return colors[curr] == currColor;
		}
		colors[curr] = currColor;
		for (int next : graph[curr]) {
			if (!validGraph(graph, colors, next, -currColor))
				return false;
		}
		return true;
	}

}
