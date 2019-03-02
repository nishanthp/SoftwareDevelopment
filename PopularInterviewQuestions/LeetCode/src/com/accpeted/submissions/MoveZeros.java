package com.accpeted.submissions;

public class MoveZeros {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	// a tricky problem 
	public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while(right < nums.length){
        	// This is the important part to maintain relavent position of non-zeros elements in the array.
            if(nums[right] != 0) {
                //swap
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left +=1;
            }
            right +=1;
        }
    }

}
