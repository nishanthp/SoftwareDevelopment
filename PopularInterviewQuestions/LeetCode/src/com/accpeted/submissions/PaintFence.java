package com.accpeted.submissions;

import java.util.HashMap;

public class PaintFence {

	public static void main(String[] args) {
		// Ran on leetcode
		HashMap<Character, Integer> map = new HashMap<>();

	}
	
	public int numWays(int n, int k) {
	      if(n==0 || k == 0) return 0; 
	      int[] dp = new int[n];
	        for(int i=0;i<n;i++){
	            if(i == 0) {
	                dp[i] = k;
	            }else if(i==1){
	                dp[i] = k*k;
	            }else {
	                dp[i] = (k-1) * dp[i-1] + dp[i-2]*(k-1);
	            }
	        }
	        return dp[n-1];
	    }

}
