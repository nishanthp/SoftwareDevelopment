package com.accpeted.submissions;

public class BuySell4 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	public int maxProfit(int k, int[] prices) {
        if(k >= prices.length/2) {
            return maxTransProfit(prices);
        }
        int[][] dp = new int[k+1][prices.length];
        for(int i=1;i<=k;i++){
            int localMax = -prices[0]; // for any row.
            for(int j=1;j<prices.length;j++){
                dp[i][j] = Math.max(dp[i][j-1], prices[j]+localMax);
                localMax = Math.max(localMax, dp[i-1][j-1]-prices[j]);
            }
        }
        return dp[k][prices.length-1];
    }
    
     public int maxTransProfit(int[] prices) {
         int maxSoFar = 0;
         for(int i=1;i<prices.length;i++){
             if(prices[i]-prices[i-1] > 0) maxSoFar += prices[i]-prices[i-1];
         }
          return maxSoFar;
     }

}
