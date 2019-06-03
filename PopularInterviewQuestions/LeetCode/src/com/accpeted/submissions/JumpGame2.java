package com.accpeted.submissions;

public class JumpGame2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Take an example and solve it. 
	public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=1;i<nums.length;i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int start =0 ; start < nums.length-1 ;start++){
            for(int end=start+1; end<=start+nums[start] && end<nums.length; end++){
                dp[end] = Math.min(dp[end], dp[start]+1);
            }
        }
        return dp[nums.length-1];
    }

}
