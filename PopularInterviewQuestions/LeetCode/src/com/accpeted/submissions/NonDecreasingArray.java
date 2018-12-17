package com.accpeted.submissions;

public class NonDecreasingArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean checkPossibility(int[] nums) {
        boolean seen = false;
        for(int i=1;i<nums.length;i++){
            if (nums[i] < nums[i-1] && seen) return false;
            else if (nums[i] < nums[i-1]) {
                seen = true;
                if(i-2 >=0 && nums[i] < nums[i-2]){
                    nums[i] = nums[i-1];
                }
            }
        }
        return true;
    }

}
