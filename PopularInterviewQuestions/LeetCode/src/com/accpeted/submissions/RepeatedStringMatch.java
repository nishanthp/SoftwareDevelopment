package com.accpeted.submissions;

public class RepeatedStringMatch {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	public int repeatedStringMatch(String A, String B) {
        int count=1;
        StringBuilder sb = new StringBuilder();
        sb.append(A);
        while(sb.length()<B.length()){
            sb.append(A);
            count+=1;
        }
        if(sb.toString().contains(B)) return count;
        sb.append(A);
        if(sb.toString().contains(B)) return ++count;
        else return -1;
    }

}
