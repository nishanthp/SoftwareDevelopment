package com.accpeted.submissions;

public class ValidPalindrome2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public boolean validPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) break;
            i++;
            j--;           
        }
        if(i>=j) return true;
        //This is the tricky part. At this point, either increment i or  decrement j and check again as it is 
        // substring, not subsequence.
        return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
    }
    
    public boolean isPalindrome(String s, int i, int j){
        while(i<j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

}
