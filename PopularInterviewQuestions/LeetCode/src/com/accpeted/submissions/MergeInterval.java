package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MergeInterval {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new LinkedList<Interval>();
        if (intervals.size() <=1) return intervals;   
        Collections.sort(intervals, new Comparator<Interval>(){
        	@Override
            public int compare(Interval i1, Interval i2){
                Integer is1 = i1.start;
                Integer is2 = i2.start;
                Integer ie1 = i1.end;
                Integer ie2 = i2.end;
                if (is1 != is2) return Integer.compare(is1, is2);
                else return Integer.compare(ie1, ie2); 
            }
        });
        // this is the important part. Don't keep one pointer for each
        // interval, but two pointers for each interval.
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        
        for(Interval interval : intervals){
            if(interval.start <= end) end = Math.max(interval.end, end);
            else {
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }
	
	
	

	// If the input is not an object.
	public int[][] merge(int[][] intervals) {
	    if(intervals.length == 0 || intervals[0].length == 0) return new int[0][0];
	    List<int[]> res = new ArrayList<int[]>();
	    // look at how it can be sorted. 
	    Arrays.sort(intervals, new Comparator<int[]>(){
	        @Override
	        public int compare(int[] n1, int[] n2){
	            return Integer.compare(n1[0], n2[0]);
	        }
	    });
	    int start = intervals[0][0];
	    int end = intervals[0][1];   
	    for(int i=1;i<intervals.length;i++){
	        if(intervals[i][0] <= end) {
	            end = Math.max(end, intervals[i][1]);
	        } else {
	            res.add(new int[]{start, end});
	            start = intervals[i][0];
	            end = intervals[i][1];
	        }
	        
	    }
	    res.add(new int[]{start, end});
	    // below line converts List<int[]> to int[][]
	    return res.toArray(new int[res.size()][]);
	}

}

class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }

