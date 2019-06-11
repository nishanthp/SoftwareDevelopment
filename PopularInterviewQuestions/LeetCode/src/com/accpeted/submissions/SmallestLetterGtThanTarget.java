package com.accpeted.submissions;

public class SmallestLetterGtThanTarget {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public char nextGreatestLetter(char[] letters, char target) {
        if(letters.length == 0) return ' ';
        int left = 0;
        int right = letters.length-1;
        char result = letters[0];
        while(left <= right){
            int mid = (left+right)/2;
            if(letters[mid] <= target) left = mid+1;
            else {
                result = letters[mid];
                right = mid-1;
            }
        }
        return result;
    }

}
