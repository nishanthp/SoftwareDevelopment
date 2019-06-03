package com.accpeted.submissions;

import java.util.Arrays;
import java.util.HashSet;

public class ThreeSumLess {

	public static void main(String[] args) {
		// Ran on leetcode.
		HashSet<Integer> s = new HashSet<>();
	}
	
	public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<=nums.length-3;i++){
            int l=i+1;
            int r = nums.length-1;
            while(l<r){
                if(nums[l] + nums[r] + nums[i] < target) {
                    count+=r-l;
                    l++;
                } else r--;
            }
        }
        return count;
    }

}
