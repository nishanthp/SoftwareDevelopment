package com.common.templates;

import java.util.Arrays;

public class UnionFind {

	public static void main(String[] args) {
		// Graph with a loop.
		int n = 3;
		int[][] edges = {{0, 1}, {1, 2}, {0, 2}};
		System.out.println(unionFind(edges, n));
	}

	private static boolean unionFind(int[][] edges, int n) {
		int[] parents = new int[n];
		Arrays.fill(parents, -1);
		for (int[] each_edge : edges) {
			int px = findParent(each_edge[0], parents);
			int py = findParent(each_edge[1], parents);
			if (px != py)
				parents[px] = py;
			else
				return true;
		}
		return false;
	}

	private static int findParent(int i, int[] parents) {
		if (parents[i] == -1)
			return i;
		return findParent(parents[i], parents);
	}

}
