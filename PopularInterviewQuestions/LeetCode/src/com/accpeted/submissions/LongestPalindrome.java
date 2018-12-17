package com.accpeted.submissions;

import java.util.HashSet;

public class LongestPalindrome {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count +=2;
            }
            else set.add(s.charAt(i));
        }
        return set.size() >= 1 ? count+1 : count;
    }

}
