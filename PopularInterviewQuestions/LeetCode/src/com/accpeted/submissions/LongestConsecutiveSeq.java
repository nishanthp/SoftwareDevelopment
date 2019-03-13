package com.accpeted.submissions;

import java.util.HashSet;

public class LongestConsecutiveSeq {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// not exactly union find. But a grouping problem using hashSet, can use a hashmap too.
	// Or even a heap.
	public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int n : nums) {
            set.add(n);
        }
        int maxCount = 0;
        for(int i=0;i<nums.length;i++){
            int count=1;
            int lower = nums[i];
            while(set.contains(--lower)){
                count++;
                set.remove(lower);
            }
            int higher = nums[i];
            while(set.contains(++higher)){
                count++;
                set.remove(higher);
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

}
