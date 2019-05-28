package com.accpeted.submissions;

public class PowerOfX {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public int mySqrt(int x) {
        int low=1;
        int high=x;
        int res = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(mid <= x/mid) {
                low=mid+1;
                // this is the tricky part. Keep reassigning res if mid <= x, till low converges with high.
                res =  mid;
            }
            else high = mid-1;
        }
        return res;
    }

}
