package com.accpeted.submissions;

import java.util.HashMap;

public class SubArrayEqK {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(sum == k) count+=1;
            // Below is the important part. Similar problem in trees. 
            if(map.containsKey(sum-k)){
                 count +=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }

}
