package com.accpeted.submissions;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean isIsomorphic(String s, String t) {
        if(s==null && t==null) return true;
        if(s.length() ==0 && t.length() == 0) return true;
        if(s.length() != t.length()) return false;
        HashMap<Character,Character> map = new HashMap<Character,Character>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))) {
                char currCh = map.get(s.charAt(i));
                if(currCh != t.charAt(i)) return false;         
            } else {
            	// This is the important part. Ex: "aa", "ba"
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }
            
        }
        return true;
    }

}
