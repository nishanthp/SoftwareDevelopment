package com.accpeted.submissions;

import java.util.HashMap;

public class LongestSubStringAtMostkDistinct {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s == null) return 0;
        if(s.length() < k) return s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int end = 0;
        int counter = 0;
        int maxLength = 0;
        while(end < s.length()){
            if(map.containsKey(s.charAt(end))){
                map.put(s.charAt(end), map.get(s.charAt(end))+1);
            } else {
                map.put(s.charAt(end),1);
                 counter++;
            }  
            end ++;
            while(counter > k) { 
                //System.out.println(end);
                System.out.println(s.substring(start, end));
                if(map.containsKey(s.charAt(start))) {
                    int temp = map.get(s.charAt(start))-1;
                    if(temp == 0) {
                        System.out.println("remove "+s.charAt(start));
                        map.remove(s.charAt(start));
                        //update counter size.
                        counter-=1;
                    } else {
                        map.put(s.charAt(start), temp);
                    }
                    
                }
                start++;
            }
            maxLength = Math.max(maxLength, end-start);
            
        }
        return maxLength;
    
    }

}
