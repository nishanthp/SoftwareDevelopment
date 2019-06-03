package com.accpeted.submissions;

import java.util.Arrays;

public class ValidTriangle {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Similar to 3 sum.
	public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int i=nums.length-1; i>=2; i--){
            int l=0;
            int r = i-1;
            while(l<r){
                if(nums[l] + nums[r] > nums[i]){
                    count += r - l; 
                    r--;
                } else l++;
            }
        }
        return count;
    }

}
