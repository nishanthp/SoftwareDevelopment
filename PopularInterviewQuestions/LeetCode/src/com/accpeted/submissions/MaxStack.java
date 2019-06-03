package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxStack {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	Deque<Integer> stack;
    int globalMax = Integer.MIN_VALUE;
    /** initialize your data structure here. */
    public MaxStack() {
        stack = new ArrayDeque<Integer>();
    }
    
    public void push(int x) {
        if(x >= globalMax) {
            stack.push(globalMax);
            globalMax = x;
        }
        stack.push(x);
    }
    
    public int pop() {
        int curr = 0;
        if(stack.peek() == globalMax) {
            curr = stack.pop();
            globalMax = stack.pop();
        } else {
            curr = stack.pop();
        }
        return curr;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return globalMax;
    }
    
    public int popMax() {
        Deque<Integer> temp = new ArrayDeque<Integer>();
        while(stack.peek() != globalMax) {
            temp.push(this.pop());
        }
        int curr = this.pop();
        while(!temp.isEmpty()) {
            this.push(temp.pop());
        }
        return curr;
    }
}
