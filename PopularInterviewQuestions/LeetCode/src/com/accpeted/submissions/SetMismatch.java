package com.accpeted.submissions;

import java.util.HashSet;

public class SetMismatch {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        int [] result = new int[2];
        int n = nums.length;
        int totalSum = (n*(n+1)/2);
        for(int i=0;i<nums.length;i++){
            if (i+1 != nums[i]) result[1] = i+1;
            if(set.contains(nums[i])) result[0] = nums[i];
            set.add(nums[i]);
            totalSum -= nums[i];
        }
         // This is the important part. Only works if there is one duplicate number.
        result[1] = totalSum + result[0];
        return result;
    }

}
