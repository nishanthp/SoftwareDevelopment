package com.accpeted.submissions;

public class LongestPalSubString {

	public static void main(String[] args) {
		// TODO Ran on leetcode.

	}
	// this is continous.
	int maxLength, begin; 
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        
        // Have to check for odd/even palindrome with each char as the center.
        for(int i=0;i<s.length();i++){
        	//assuming its odd.
            extendPalindrome(s, i, i);
            //assuming its even.
            extendPalindrome(s, i, i+1); 
        }
        return s.substring(begin, begin+maxLength);
    }
    
    public void extendPalindrome (String s, int start, int end){
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start --;
            end ++;
        }
        
        if(maxLength < end-start-1){
            begin = start+1;
            maxLength = end-start-1;
        }
     
    }

}
