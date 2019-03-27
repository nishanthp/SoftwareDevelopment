package com.accpeted.submissions;

public class MaxConsecutiveOnes {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int counter = 0;
        while(right < nums.length){
            if(nums[right] == 1) {
                while(right < nums.length && nums[left] == nums[right]){
                counter++;
                right++;
            } 
                maxCount = Math.max(maxCount, counter);
                counter = 0;
                left = right;
            } else {
                right++;
            }
            
        }
        maxCount = Math.max(maxCount, counter);
        return maxCount;
    }

}
