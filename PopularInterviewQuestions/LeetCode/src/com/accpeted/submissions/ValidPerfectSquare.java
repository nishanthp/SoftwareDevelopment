package com.accpeted.submissions;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// variation of pow(num).
	public boolean isPerfectSquare(int num) {
        if(num == 0) return false;
        int low=1;
        int high=num;
        while(low<=high){
            int mid = (low+high)/2;
            if(mid * mid == num) return true;
            if(mid < num/mid)  low=mid+1;
            else high = mid-1;
        }
        return false;
    }

}
