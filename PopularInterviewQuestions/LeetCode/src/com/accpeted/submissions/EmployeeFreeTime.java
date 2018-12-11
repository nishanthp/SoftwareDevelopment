package com.accpeted.submissions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class EmployeeFreeTime {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
		public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
	        List<Interval> result = new LinkedList<Interval>();
	        List<Interval> intervals = new LinkedList<Interval>();
	        schedule.forEach(e -> intervals.addAll(e));
	        Collections.sort(intervals, ((a,b) -> a.start==b.start ? a.end - b.end : a.start-b.start));
	    
	        Interval temp = intervals.get(0);
	        for(Interval eachInterval : intervals){
	            if(temp.end < eachInterval.start) {  
	                result.add(new Interval(temp.end,eachInterval.start));  
	                temp = eachInterval;
	            } else {
	                temp = temp.end < eachInterval.end ? eachInterval : temp;
	            }
	            
	        }
	        return result;
	    }
    

}
