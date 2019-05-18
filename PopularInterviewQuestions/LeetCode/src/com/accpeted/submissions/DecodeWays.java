package com.accpeted.submissions;

public class DecodeWays {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	
	// Classic memonization/dp problem. Cannot do it with recursive BT.
	public int numDecodings(String s) {
        int n = s.length();
        int[] memo = new int[n+1];
        memo[n] = 1;
        memo[n-1] = s.charAt(n-1) == '0' ? 0 : 1;
        
        for(int i=n-2;i>=0;i--){
            if (s.charAt(i) == '0') continue;
            else memo[i] = Integer.parseInt(s.substring(i,i+2)) <= 26 ? memo[i+1] + memo[i+2] : memo[i+1];  
        }
        return memo[0];
    }

}
