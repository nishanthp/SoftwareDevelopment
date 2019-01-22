package com.accpeted.submissions;

public class OneEditDistance {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Small variance of the original one.
	public boolean isOneEditDistance(String s, String t) {
        int[][]  dp = new int[s.length()+1][t.length()+1];
        for(int i=0; i<= s.length();i++){
            dp[i][0] = i;
        }
        for(int i=0; i<= t.length();i++){
            dp[0][i] = i;
        }
        
        for(int i=1;i<=s.length();i++){
            for(int j=1;j<=t.length();j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                    
                } else {
                    dp[i][j] = 1+ Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
                }
            }
        }
        return dp[s.length()][t.length()] == 1;
    }

}
