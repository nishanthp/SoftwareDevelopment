package com.accpeted.submissions;

import java.util.Arrays;
import java.util.HashMap;

public class RedundantConnection {

	public static void main(String[] args) {
		// Ran on leetcode.
		HashMap<Integer, Integer> map = new HashMap<>();

	}
	
	// follow the union find template. Find the cycle in a graph.
	public int[] findRedundantConnection(int[][] edges) {
        int [] parent = new int[edges.length+1];
        Arrays.fill(parent, -1);
        for(int[] edge : edges) {
            int x = findParent(parent, edge[0]);
            int y = findParent(parent, edge[1]);
            if(x == y) return edge;
            parent[x] = y;
        }
        return new int[2];
    }
    
    public int findParent(int[] parent, int i){
        if(parent[i] == -1) return i;
        return findParent(parent, parent[i]);
    }

}
