package com.accpeted.submissions;

import java.util.HashMap;

public class UniqueBST1 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        map.put(0,1);
        map.put(1,1);
        return numberOfTrees(n);
    }
    
    public int numberOfTrees (int n) {
        if (map.containsKey(n)) return map.get(n);
        int sum=0;
        for(int root=1;root<=n; root++){
            sum += numberOfTrees(root-1) * numberOfTrees (n-root);
        }
        map.put(n, sum);
        return sum;
    }

}
