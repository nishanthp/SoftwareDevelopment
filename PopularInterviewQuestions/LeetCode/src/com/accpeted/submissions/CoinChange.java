package com.accpeted.submissions;

public class CoinChange {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public int coinChange(int[] coins, int amount) {
        if(coins.length == 0 || amount == 0) return 0;
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]  = Integer.MAX_VALUE;
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                dp[i][j] = dp[i-1][j];
                // below is the important part.
                if(j >= coins[i-1]) {
                    if(dp[i][j-coins[i-1]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][j-coins[i-1]]);
                    }
                }
            }
        }
        return dp[coins.length][amount] == 0 || dp[coins.length][amount] == Integer.MAX_VALUE ? -1 : dp[coins.length][amount];
    }

}
