package com.accpeted.submissions;

public class ReverseWordsInString {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	// Not important. Have time look into it.
	public String reverseWords(String s) {
        if(s == null || s.length() == 0) return "";
        s = s.trim();
        String[] input = s.split(" ");
        StringBuilder sd = new StringBuilder();
        for(int i=input.length-1;i>=0;i--){
            if(input[i].length() > 0){
                sd.append(input[i]).append(" ");
            } 
        }
        return sd.toString().trim();
    }

}
