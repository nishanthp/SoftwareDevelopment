package com.accpeted.submissions;

public class StudentAttRecord {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean checkRecord(String s) {
        boolean absent =false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'A'){
                if(absent) return false;
                absent = true;
            } else if (s.charAt(i) == 'L') {
                int j = i;
                int count=0;
                while(j<s.length() && s.charAt(j)=='L') {   
                    j++;
                    count++;
                    if(count > 2) return false;
                }
            }
        }
        return true;
    }

}
