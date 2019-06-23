package com.accpeted.submissions;

public class PalindromicSubstrings {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	 int count = 0;
	    public int countSubstrings(String s) {
	        if(s == null || s.length() == 0) return 0;
	        for(int i=0;i<s.length();i++){
	            checkPalindrome(s, i, i); // even length
	            checkPalindrome(s, i, i+1); // odd length
	        }     
	        return count;
	    }
	    
	    public void checkPalindrome(String s , int start, int end) {
	        while(start <= end && start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
	            start-=1;
	            end+=1;
	            count+=1;
	        }

}
}
