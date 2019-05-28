package com.accpeted.submissions;

import java.util.Arrays;

public class PerfectSquares {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Time complexity - O(n*n^1/2)
	public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<dp.length;i++){
            int j=1;
            while(i-j*j >= 0){
                dp[i] = Math.min(dp[i-j*j]+1, dp[i]);
                j++;
            }
        }
        return dp[n];
    }
}
