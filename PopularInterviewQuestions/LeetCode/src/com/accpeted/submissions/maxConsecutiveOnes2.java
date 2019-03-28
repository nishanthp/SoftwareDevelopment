package com.accpeted.submissions;

public class maxConsecutiveOnes2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int right = 0;
        int maxCount = 0;
        int counter = 0;
        boolean maxFlip = false;
        while(right < nums.length) {
            while(right < nums.length && (nums[right] == 1 || !maxFlip)) {
                if(nums[right] == 0) maxFlip = true;
                counter++;
                right++;
            }
            maxCount = Math.max(maxCount, counter);
            if (nums[left] == 0) maxFlip = false;
            left++;
            counter--;
        }
        maxCount = Math.max(maxCount, counter);
        return maxCount;
    }

}
