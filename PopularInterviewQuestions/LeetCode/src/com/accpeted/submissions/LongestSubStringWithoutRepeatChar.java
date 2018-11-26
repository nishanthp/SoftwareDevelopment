package com.accpeted.submissions;

import java.util.HashMap;

public class LongestSubStringWithoutRepeatChar {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int leftIndex=0;
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
            	// Concentrate on the below part. Its the last location of the previously found char + 1. 
                leftIndex = Math.max(leftIndex, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i),i);
            maxLength = Math.max(maxLength, i-leftIndex+1);
        }
        return maxLength;
    }

}
