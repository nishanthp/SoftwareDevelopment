package com.accpeted.submissions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class ReverseVowels {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public String reverseVowels(String s) {
        int start = 0;
        int end = s.length()-1;
        char [] sA = s.toCharArray();
        String vowels = "aeiouAEIOU";
        while(start < end){
        	// one way to convert char to String. There are many other ways.
            while(start < end && !vowels.contains(sA[start]+"")){
                start +=1;
            }
            while(start < end && !vowels.contains(sA[end]+"")){
                end -=1;
            }
            char temp  = sA[start];
            sA[start]  = sA[end];
            sA[end]  = temp;
            start +=1;
            end -=1;
        }
        return new String(sA);
    }

}
