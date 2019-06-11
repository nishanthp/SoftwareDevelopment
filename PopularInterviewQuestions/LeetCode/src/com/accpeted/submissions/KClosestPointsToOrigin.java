package com.accpeted.submissions;

import java.util.Arrays;

public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	 public int[][] kClosest(int[][] points, int K) {
	        if(points.length == 0) return points;
	        int left = 0;
	        int right = points.length-1;
	        left = kClosestOther(points, left, right, K);
	        return left == - 1 ? Arrays.copyOfRange(points, 0, K) : Arrays.copyOfRange(points, 0, left);
	    }
	    
	    public int kClosestOther(int[][] A, int low, int high, int k) {
	        if(low > high) return -1;
	        int left = low;
	        int[] pivot = A[high];
	        
	        for(int i=left; i<high;i++){
	            if(compare(A[i], pivot) <=0) {
	                int[] temp = A[i];
	                A[i] = A[left];
	                A[left++] = temp;
	                
	            }
	        }
	        int[] temp = A[high];
	        A[high] = A[left];
	        
	        A[left] = temp;
	        if(left == k) return left;
	        else if(left < k)  return kClosestOther( A, left+1,  high,  k);
	        return kClosestOther( A, low,  left-1,  k);
	    }
	    
	    public int compare(int[] n1, int[] n2) {
	        return n1[0]*n1[0]+n1[1]*n1[1]- n2[0]*n2[0] - n2[1]*n2[1];
	    }
}
