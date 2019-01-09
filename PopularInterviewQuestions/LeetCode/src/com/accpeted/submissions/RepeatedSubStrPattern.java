package com.accpeted.submissions;

public class RepeatedSubStrPattern {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean repeatedSubstringPattern(String s) { 
        int l = s.length();
        for(int i=1;i<=l/2;i++){
            String temp = s.substring(0,i);
            if((l%i) == 0) {
                int num = l/i;
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<num;j++){
                    sb.append(temp);
                }
                
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
    

}
