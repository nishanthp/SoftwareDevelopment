package com.accpeted.submissions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RotateArray {

	public static void main(String[] args) {
		// Ran both on leetcode.
		List<List<Integer>> list = new LinkedList<>();
		list.get(0).get(1);
	}
	
	//This is without extra space.
	public void rotate(int[] nums, int k) {
        if(nums.length == 0 || nums.length == 1 || k == 0)return;
        if(nums.length == k) return;
        if(k >= nums.length) k %=nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
    public void reverse(int []nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

	
	//More space.
	 public void rotateWithSpace(int[] nums, int k) {
	        if(nums.length == 0 || nums.length == 1 || k == 0)return;
	        if(nums.length == k) return;
	        if(k >= nums.length) k %=nums.length;
	        int[] result = new int[nums.length];
	        int j=0;
	        int s = nums.length - k;
	        for(int i=s;i<nums.length;i++){
	            result[j++] = nums[i]; 
	        }
	        System.out.println(j);
	        
	        for(int i=0;i<s;i++){
	            if(j< nums.length) {
	                result[j++] = nums[i];
	            }
	        }
	         for(int i=0;i<nums.length;i++){
	            nums[i] = result[i];
	        }
	    }
	 
	 // Not the correct way to do it. But analyze.
	 public boolean can(int numCourses, int[][] prerequisites, int courseTaken, int index) {
	        if(index > prerequisites.length-1 || numCourses == courseTaken) return true; 
	        int[] curr = prerequisites[index];
	        for(int i=0;i<prerequisites.length;i++){
	            if(index == i) continue;
	            if(prerequisites[i][0] == curr[1] && prerequisites[i][1] == curr[0]) return false;
	            list.add(Arrays.asList(curr));
	            list.add(Arrays.asList(prerequisites[i]));
	            if (can(numCourses, prerequisites, courseTaken, index++)) {
	                return true;
	            }   
	        }
	        courseTaken += list.size()*2;
	        System.out.println(courseTaken);
	        return true;
	}

}
