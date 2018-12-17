package com.accpeted.submissions;

public class RemoveElement {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	 public int removeElement(int[] nums, int val) {
	        int start = 0;
	        int current = start;
	        while(current < nums.length){
	        	// Same as move zeros.
	            if(nums[current] != val) {
	                int temp = nums[current];
	                nums[current] = nums[start];
	                nums[start] = temp;
	                start +=1;
	            }
	            current +=1;
	        }
	        return start;
	    }

}
