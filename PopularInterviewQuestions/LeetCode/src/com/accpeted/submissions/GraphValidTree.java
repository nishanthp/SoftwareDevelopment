package com.accpeted.submissions;

import java.util.Arrays;

public class GraphValidTree {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Another union find problem. Follow the below template.
	public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        Arrays.fill(parent,-1);
        for(int[] edge: edges){
            int x = findParent(parent, edge[0]);
            int y = findParent(parent, edge[1]);
            if(x==y) return false;
            else parent[x] = y;
        }
        int count=0;
        for(int i : parent) {
            if(i== -1) {
                count +=1;
                if(count > 1) return false;
            }
        }
        return true;
    }
    
    public int findParent(int[] parent, int i){
        if(parent[i] == -1) return i;
        return findParent(parent, parent[i]);
    }

}
