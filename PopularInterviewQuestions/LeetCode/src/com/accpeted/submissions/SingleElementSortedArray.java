package com.accpeted.submissions;

public class SingleElementSortedArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int singleNonDuplicate(int[] nums) {
        if(nums.length == 0) return -1;
        int low = 0;
        int right = nums.length-1;
        while(low < right){
           int mid = (low+right)/2;
           if(mid % 2 == 1) mid--;
            if(nums[mid] == nums[mid+1]) low = mid + 2;
            else right = mid;
        }
        return nums[low];
    }

}
