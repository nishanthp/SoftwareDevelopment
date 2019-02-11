package com.accpeted.submissions;

import java.util.HashMap;

public class MinimumWindowSubstring {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Classic variant of sliding window problem. Very popular one.
	public String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character,Integer>();
        
        // build the map.
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0)+1);        
        }
        
        int start = 0;
        int end = 0;
        int counter=map.size();
        int minWindow = Integer.MAX_VALUE;
        String result = "";
        while(end < s.length()){
            if(map.containsKey(s.charAt(end))) {
                int temp = map.get(s.charAt(end))-1;
                if (temp == 0) counter -=1;
                map.put(s.charAt(end), temp);
            }
            end++;
            // begin moving start.
            while(counter == 0) {
               if (minWindow > end-start+1) {
                   minWindow = Math.min(minWindow, end-start+1);
                   result = s.substring(start, end);
               }
               if(map.containsKey(s.charAt(start))) {
                int temp = map.get(s.charAt(start))+1;
                if(temp > 0) counter +=1;
                map.put(s.charAt(start), temp);
               } 
                start ++;
            }
            
        }
        return result;
    }

}
