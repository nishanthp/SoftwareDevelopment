package com.accpeted.submissions;

import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// There are multiple ways to solve this. 
	Deque<Integer> stack;
    int globalMin = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    
    public MinStack() {
         stack = new LinkedList<Integer>();
    }
    
    public void push(int x) {
         if(x<=globalMin){
        	// This is the trick.
             stack.push(globalMin);
             globalMin = x;
         }
        stack.push(x);
    }
    
    public void pop() {
    	// This one too.
       if(stack.pop() == globalMin) globalMin = stack.pop();
    }
    
    public int top() {
      return stack.peek();
    }
    
    public int getMin() {
        return globalMin;
    }

}
