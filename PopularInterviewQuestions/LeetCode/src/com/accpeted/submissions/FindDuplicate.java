package com.accpeted.submissions;


public class FindDuplicate {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	// binary search based on range. low,high and mid need not be a part of the array.
	public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        
        while(low <= high){
            int mid = (low + high) /2;
            int count=0;
            for(int i:nums){
                if(i <= mid) count +=1;
            }
            if(count <= mid) low = mid+1;
            else high = mid-1;
        }
        return low;
    }
}


class Interval{
	
}