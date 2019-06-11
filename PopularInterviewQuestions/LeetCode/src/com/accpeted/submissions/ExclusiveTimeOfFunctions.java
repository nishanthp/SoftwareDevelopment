package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ExclusiveTimeOfFunctions {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	 public int[] exclusiveTime(int n, List<String> logs) {
	        Deque<Integer> stack = new ArrayDeque<Integer>();
	        int prevTime = 0;
	        int[] res = new int[n];
	        for(String log : logs){
	            String[] parts = log.split(":");
	            int id = Integer.valueOf(parts[0]);
	            int currTime = Integer.valueOf(parts[2]);
	            if(parts[1].equals("start")) {
	                if(!stack.isEmpty()) { // another process has started.
	                    res[stack.peek()] += currTime-prevTime;
	                }
	                stack.push(id);
	                prevTime = currTime;
	            } else {
	                res[stack.pop()] += currTime - prevTime +1;
	                prevTime = currTime + 1;
	            }
	        }
	        return res;
	    }

}
