package com.accpeted.submissions;

public class PartitionToKEqualSumSubSets {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalSum = 0;
        for(int i=0;i<nums.length;i++){
            totalSum += nums[i];
        }
        int targetSum = totalSum/k;
        if(totalSum % k != 0) return false;
        boolean[] visited = new boolean[nums.length]; 
        return canPartitionKSubsets(nums, targetSum, 0, visited, k, 0);
    }
    
    
     public boolean canPartitionKSubsets(int[] nums, int targetSum, int runningSum, boolean[] visited, int k, int start) {
         if(k == 0) return true;
         if(runningSum > targetSum) return false;       
         if(runningSum == targetSum) {
             return canPartitionKSubsets(nums, targetSum, 0, visited, k-1, 0);
         }
         
         for(int i=start;i<nums.length;i++){
             if(!visited[i]) {
                 visited[i] = true;
                 if(canPartitionKSubsets(nums, targetSum, runningSum+nums[i], visited, k, i+1)) return true;
                 visited[i] = false;
             }
             
         }
         return false;
     }

}
