package com.accpeted.submissions;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		// Ran on leetcode.
		String s = "abudnj";
		String pre = "dnj";
		System.out.println(s.indexOf(pre));
	}
	
	public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String commonPrefix=strs[0];
        for(int i=1;i<strs.length;i++) {
        	// indexOf is a string method which returns -1 if the substring does not exist. else the index of the substring's first occurrence. 
            while(strs[i].indexOf(commonPrefix)!= 0 && commonPrefix.length()>0) commonPrefix = commonPrefix.substring(0,commonPrefix.length()-1);      
        }
        return commonPrefix;
    }

}
