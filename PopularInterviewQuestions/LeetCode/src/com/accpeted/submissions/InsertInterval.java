package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int[][] insert(int[][] intervals, int[] newInterval) {
	       List<int[]> result = new ArrayList<int[]>();
	        for(int[] each : intervals){
	            if(newInterval.length == 0 || each[1] < newInterval[0]) {
	                result.add(each);
	            } else if (each[0] > newInterval[1]) {
	                result.add(newInterval);
	                result.add(each);
	                newInterval = new int[0];   
	            } else {
	                int start = Math.min(each[0], newInterval[0]);
	                int end = Math.max(each[1], newInterval[1]);
	                newInterval = new int[]{start, end};
	            }
	            
	        }
	        if (newInterval.length != 0 ) result.add(newInterval);
	        return result.toArray(new int[result.size()][]);
	    }

}
