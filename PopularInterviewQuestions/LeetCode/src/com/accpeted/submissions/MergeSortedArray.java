package com.accpeted.submissions;

public class MergeSortedArray {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	// Without any extra space.
	public void mergeWithoutExtraSpace(int[] nums1, int m, int[] nums2, int n) {
        int n1Index = m-1;
        int n2Index = n-1;
        int resultIndex = m+n-1;
        while(n1Index >= 0 && n2Index >= 0){
            nums1[resultIndex--] = nums1[n1Index] > nums2[n2Index] ? nums1[n1Index--] : nums2[n2Index--];
        }
        
        while(n2Index >= 0) {
            nums1[resultIndex--] = nums2[n2Index--];
        }
    }
	
	// with extra space.
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[m+n];
        int n1Index=0; 
        int n2Index=0; 
        int resIndex=0;
        while(n1Index < m && n2Index < n) {
            if(nums1[n1Index] < nums2[n2Index]){
                result[resIndex++] = nums1[n1Index];
                n1Index++;
            } else {
                result[resIndex++] = nums2[n2Index];
                n2Index++;
            }
        }
        
        while(n1Index < m){
            result[resIndex++] = nums1[n1Index];
            n1Index++;
        }
        
        while(n2Index < n){
            result[resIndex++] = nums2[n2Index];
            n2Index++;
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = result[i];
        }
    }

}
