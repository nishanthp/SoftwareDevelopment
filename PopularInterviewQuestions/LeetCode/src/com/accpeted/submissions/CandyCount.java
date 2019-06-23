package com.accpeted.submissions;

import java.util.Arrays;

public class CandyCount {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int candy(int[] ratings) {
        if(ratings == null || ratings.length == 0) return 0;
        int runningSum = 0;
        int[] res = new int[ratings.length];
        Arrays.fill(res, 1);
        // left to right
        for(int i=1; i<ratings.length;i++){
            if(ratings[i] > ratings[i-1]) res[i] = Math.max(res[i], res[i-1]+1);
        }
        
        // right to left
        for(int i=ratings.length-2;i>=0;i--){
            if(ratings[i] > ratings[i+1]) res[i] = Math.max(res[i], res[i+1]+1);
        }
        
        for(int candies : res){
            runningSum += candies;
        }
        
        return runningSum;
    }

}
