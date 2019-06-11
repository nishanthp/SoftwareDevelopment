package com.accpeted.submissions;

import java.util.Random;
import java.util.TreeMap;

public class RandomPickWithWeight {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	TreeMap<Integer, Integer> map;
    int runningSum = 0;
    Random r;
    public void Solution(int[] w) {
        r = new Random();
        map = new TreeMap<Integer, Integer>();
        // below is the most important part. Similar to bucket of balls problem.
        for(int i=0;i<w.length;i++){
            runningSum += w[i];
            map.put(runningSum, i);
        }
    }
    
    public int pickIndex() {
    	// below line time complexity is O(log n)
        int key = map.higherKey(r.nextInt(runningSum));
        return map.get(key);
    }

}
