package com.accpeted.submissions;

public class ReverseWordsInString2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public void reverseWords(char[] str) {
        if(str.length == 0) return;
        reverse(str, 0, str.length-1);
        int j=0;
        for(int i=0;i<str.length;i++){
            if(str[i] == ' ') {
                reverse(str, j, i-1);
                j=i+1;
            }
            if(i == str.length -1) {
                reverse(str, j, i);
            }
            
        }
    }
    
    public void reverse(char[] input, int start, int end) {
        while(start < end){
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

}
