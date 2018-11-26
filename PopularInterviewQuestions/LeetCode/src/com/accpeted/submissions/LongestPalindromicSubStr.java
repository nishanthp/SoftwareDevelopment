package com.accpeted.submissions;

public class LongestPalindromicSubStr {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	//Remember substring is contigious, subsequence is non contigious.
	public int longestPalindromeSubseq(String s) {
        int[][] dp = new int [s.length()][s.length()];
        
        for(int i=0;i<s.length();i++){
            dp[i][i] = 1;
        }
        
        for(int l=2;l<=s.length();l++){
            for(int i=0;i<=s.length()-l;i++){
                int j = i+l-1;
                
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = 2 + dp[i+1][j-1];
                }else
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                
            }
        }
        return dp[0][s.length()-1];
    }

}
