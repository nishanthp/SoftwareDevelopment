package com.accpeted.submissions;

public class HouseRobberArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int rob(int[] nums) {
        int prev = 0;
        int prev_prev = 0;
        for(int num : nums){
            int temp = prev;
            prev = Math.max(prev_prev+num, prev);
            prev_prev = temp;
        }
        return Math.max(prev_prev, prev);
    }

}
