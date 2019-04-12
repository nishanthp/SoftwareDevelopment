package com.accpeted.submissions;

public class SortedSquares {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	// can be done with a minHeap too. 
	// But this would be sort of in place. A two pointer solution.
	// Ex: [-3, -2, 1] => [1, 4, 9]
	public int[] sortedSquares(int[] A) {
        if(A.length == 0) return A;
        int i = 0;
        for(i=0;i<A.length;i++){
            if(A[i] >= 0) break;
        }
        int left = i-1;
        int right = i;
        int resIndex = 0;
        int[] temp = new int[A.length];
        while(left>=0 && right < A.length){
            if(A[left] * A[left] < A[right] * A[right]) {
                 temp[resIndex++] = A[left] * A[left];
                left--;
            } else {
                temp[resIndex++] =  A[right] * A[right];
                right++;
            }
        }
        
        while(left >= 0) {
            temp[resIndex++] = A[left] * A[left];
            left--;
        }
        
        while(right < A.length){
            temp[resIndex++] =  A[right] * A[right];
            right++;
        }
        return temp;
    }

}


