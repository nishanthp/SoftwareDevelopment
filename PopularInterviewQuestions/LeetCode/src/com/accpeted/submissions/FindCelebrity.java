package com.accpeted.submissions;

import java.util.Deque;
import java.util.LinkedList;

public class FindCelebrity {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int findCelebrity(int n) {
        Deque<Integer> stack = new LinkedList<Integer>();
        
        for(int i=0;i<n;i++) stack.push(i);
        
        while(stack.size() > 1) {
            int a = stack.pop();
            int b = stack.pop();
            if(knows(a, b)) stack.push(b);
            else stack.push(a);
        }
        int candidate = stack.pop();
        for(int i=0;i<n;i++){
            if(i != candidate && (!knows(i, candidate) || knows(candidate, i))) return -1;
        }
     return candidate;      
    }

	// below api is given.
	private boolean knows(int a, int b) {
		// TODO Auto-generated method stub
		return false;
	}

}
