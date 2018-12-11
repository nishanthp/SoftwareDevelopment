package com.accpeted.submissions;

public class MoveZeros {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	// a tricky problem 
	public void moveZeroes(int[] nums) {
        int start = 0;
        int current = 0;
        while(current < nums.length){
        	// This is the important part to maintain relavent position of non-zeros elements in the array.
            if(nums[current] != 0) {
                //swap
                int temp = nums[current];
                nums[current] = nums[start];
                nums[start] = temp;
                start +=1;
            }
            current +=1;
        }
    }

}
