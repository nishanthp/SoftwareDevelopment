package com.accpeted.submissions;

public class JumpGame {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	// Same as minimum number of jumps.
	public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i=1;i<nums.length;i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int start =0 ; start < nums.length ;start++){
            for(int end=start+1; end<=start+nums[start] && end<nums.length; end++){
                if(dp[start] != Integer.MAX_VALUE) { // this check is important, as adding 1 to Integer.MAX_VALUE will make it negative. 
                	// Because of this line 26 condition will get screwed. 
                   dp[end] = Math.min(dp[end], dp[start]+1);
                }
            }
        }
        return dp[nums.length-1] == Integer.MAX_VALUE ? false : true;
    }

}
