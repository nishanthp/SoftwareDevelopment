package com.accpeted.submissions;

public class ReverseString2 {

	public static void main(String[] args) {
		// Ran on leetcode.
		

	}
	// Not commly asked question. Can ignore.
	public String reverseStr(String s, int k) {
        if(s == null) return s;
        char [] sA = s.toCharArray();
        int start = 0;
        while(start < sA.length){
            int end = Math.min(start+k-1, sA.length-1);
            reverseString(sA, start, end);
            start += 2*k;
        }
        return new String(sA);
    }
    
    public void reverseString(char[] sA, int start, int end){
            while(start < end){
            char temp = sA[start];
            sA[start] = sA[end];
            sA[end] = temp;
            start++;
            end--;
        }
}

}
