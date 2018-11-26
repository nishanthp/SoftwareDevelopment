package com.accpeted.submissions;

public class FlipGame {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Same as recursive backtracking. 
	public boolean canWin(String s) {
        if(s == null || s.length() < 2) return false; 
        
        for(int i=0;i<s.length(); i++){
            if(s.startsWith("++", i)){
                String temp = s.substring(0, i) + "--" + s.substring(i+2);
                if(!canWin(temp)) return true;
                
            }
        }
        
        return false;
    }

}
