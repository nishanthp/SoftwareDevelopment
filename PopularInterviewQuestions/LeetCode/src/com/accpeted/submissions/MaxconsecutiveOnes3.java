package com.accpeted.submissions;

public class MaxconsecutiveOnes3 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	 public int longestOnes(int[] A, int K) {
	        int left = 0;
	        int right = 0;
	        int maxCount = 0;
	        int counter = 0;
	        int maxFlip = K;
	        while(right < A.length) {
	            while(right < A.length && (A[right] == 1 || maxFlip>0)) {
	                if(A[right] == 0) maxFlip--;
	                counter++;
	                right++;
	            }
	            maxCount = Math.max(maxCount, counter);
	            if (K !=0 && A[left] == 0) maxFlip++;
	            left++;
	            if(left > right) {
	                right = left;
	                counter=0;
	            } else {
	                counter--;
	            }
	            
	        }
	        maxCount = Math.max(maxCount, counter);
	        return maxCount;
	    }

}
