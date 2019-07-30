package com.accpeted.submissions;

public class MedianTwoSorted {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1Length = nums1.length;
        int n2Length = nums2.length;
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        // nums1 should be smaller array.
        int left = 0;
        int right = nums1.length;
        while(left <= right){
            int mid1 = (left+right)/2;
            int mid2 = (n1Length + n2Length + 1)/2 - mid1 ;
            
            int n1Left = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int n1Right = mid1 == nums1.length ? Integer.MAX_VALUE : nums1[mid1];
            
            int n2Left = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int n2Right = mid2 == nums2.length ? Integer.MAX_VALUE : nums2[mid2];
            
            // Now compare.
            if(n1Left <= n2Right && n2Left <= n1Right) {
                if((n1Length+n2Length) % 2 == 0) {
                    return (Math.max(n1Left, n2Left) + Math.min(n1Right, n2Right)) / 2.0;
                } 

                return Math.max(n1Left, n2Left);
            }
            else if(n1Left > n2Right) right = mid1 - 1;
            else left = mid1 + 1; 
        }
        return -1.0;
    }

}
