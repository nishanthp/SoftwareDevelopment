package com.accpeted.submissions;

public class ValidPalindrome {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	//
	public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        s = s.toLowerCase();
        while(i<j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!Character.isLetterOrDigit(ci)){
                i++;
                continue;
            }
            // isLetterOrDigit is static method. So cannot call from Character object.
            if(!Character.isLetterOrDigit(cj)){
                j--;
                continue;
            }
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;           
        }
        return true;
    }

}
