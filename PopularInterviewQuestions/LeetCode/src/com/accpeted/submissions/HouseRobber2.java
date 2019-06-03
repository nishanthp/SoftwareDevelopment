package com.accpeted.submissions;

public class HouseRobber2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        // below is the important part.
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }
    
    public int rob(int[] nums, int start, int end) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        dp[1] = nums[start];
        for(int i=2;i<dp.length;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1+start]);
        }
        return dp[nums.length-1];
    }

}
