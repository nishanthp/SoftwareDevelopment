package com.accpeted.submissions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	 public int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums.length == 0 || k ==0) return new int[0];
	        int start = 0;
	        int end = 0;
	        int counter = 0;
	        int n = nums.length;
	        int [] result = new int[n-k+1];
	        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>(){
	            @Override 
	            public int compare(Integer n1, Integer n2) {
	                return n2.compareTo(n1);
	            }
	        }) ;
	        while(end < nums.length){
	            maxHeap.add(nums[end]);
	            counter++;
	            end++;
	            while(counter == k){
	                result[start] = maxHeap.peek();
	                maxHeap.remove(nums[start++]);
	                counter--;
	            }
	        }
	        return result;
	    }

}
