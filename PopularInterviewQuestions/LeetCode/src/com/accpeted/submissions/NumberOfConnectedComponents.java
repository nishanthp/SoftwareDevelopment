package com.accpeted.submissions;

import java.util.Arrays;

public class NumberOfConnectedComponents {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// This is union find problem. Standard problem. Very important graph problem.
	public int countComponents(int n, int[][] edges) {
        int count=0;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int[] each : edges){
            union(parent, each[0], each[1]); 
        }
        
        for(int each : parent) {
            if(each == -1) count++;
        }
        
        return count;
    }
    
    public void union(int[] parent, int i, int j) {
        int iparent = findParent(parent, i);
        int jparent = findParent(parent, j);
        if(iparent != jparent) parent[iparent] = jparent;
    }
    
    public int findParent(int[] parent, int i) {
        if(parent[i]==-1) return i;
        return findParent(parent, parent[i]);
    }

}
