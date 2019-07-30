package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestAbFile {

	public static void main(String[] args) {
		// Ran on leetcode.
		String w = "avcb";
		System.out.println(w.substring(0,1));
	}
	
	public int lengthLongestPath(String input) {
        int maxLength = 0;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        stack.push(0);
        String[] tokens = input.split("\n");
        for(String tok : tokens){
            int numOfTabs = tok.lastIndexOf("\t")+1;
            int level = numOfTabs + 1;
            System.out.println(tok);
            while(level < stack.size()) stack.pop();
            System.out.println(stack.peek());
            System.out.println(tok.length());
            System.out.println(numOfTabs);
            int curLeng = stack.peek() + tok.length() - numOfTabs + 1;
            stack.push(curLeng);
            if(tok.contains(".")) maxLength = Math.max(maxLength, curLeng-1);
        }
        return maxLength;
    }

}
