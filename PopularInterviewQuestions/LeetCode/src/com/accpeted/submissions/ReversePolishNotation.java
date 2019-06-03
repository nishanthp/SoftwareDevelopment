package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class ReversePolishNotation {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        HashSet<String> operands = new HashSet<String>();
        operands.add("+");
        operands.add("-");
        operands.add("*");
        operands.add("/");
        
        for(int i=0; i<tokens.length;i++){
            String curr = tokens[i];
            if(!operands.contains(curr)) stack.push(Integer.valueOf(curr));
            else {
                int n1 = stack.pop();
                int n2 = stack.pop();
                stack.push(calculate(n1, n2, curr));
            }
        }
        return stack.pop();
    }
    public int calculate(int n1, int n2, String op) {
        switch (op) {
            case "+":
                return n1 + n2;
            case "-":
            	// See this order. As you are putting the numbers on the stack.
                return n2 - n1;

            case "*":
                return n1*n2;

            case "/":
            	// See this order. As you are putting the numbers on the stack.
                return n2/n1;

        }
        return 0;
    }

}
