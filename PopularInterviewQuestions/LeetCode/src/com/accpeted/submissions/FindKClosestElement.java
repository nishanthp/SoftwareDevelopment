package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class FindKClosestElement {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length-k;
        List<Integer> result = new LinkedList<Integer>();
        while(low < high) {
            int mid = low + (high-low)/2;
            // This is the important part.
            if(x-arr[mid] > arr[mid+k] -x) low = mid+1;
            else high = mid;
        }
        System.out.println(low);
        for(int i=low;i<low+k;i++){
            result.add(arr[i]);
        }
        return result;
    }
}


