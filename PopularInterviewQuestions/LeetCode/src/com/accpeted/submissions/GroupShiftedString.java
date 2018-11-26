package com.accpeted.submissions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupShiftedString {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Ex: "abc" and "xyz" should fall into same bucket. 
	public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strings){
            StringBuilder builder = new StringBuilder();
            for(int i=1;i<str.length();i++){
               // So you end up storing the int value of char (diff).
               int diff = str.charAt(i) - str.charAt(i-1);
               diff = diff >= 0 ? diff: diff+26;
               builder.append(diff);
            }
            // Avioding if else.
            List<String> t = new LinkedList<String>();
            String tempStr = builder.toString();
            map.putIfAbsent(tempStr, t);
            map.get(tempStr).add(str);
        }
        //Concentrate on this. Not using a var result here. 
        return new LinkedList<>(map.values());
    }

}
