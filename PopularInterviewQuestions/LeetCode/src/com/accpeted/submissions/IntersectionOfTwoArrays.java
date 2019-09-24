package com.accpeted.submissions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0 || nums2.length == 0) return new int[0];
        List<Integer> list = new LinkedList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        if(nums1.length < nums2.length){
            for(int i : nums2){
                set.add(i);
            }
            for(int j : nums1){
                if(set.contains(j) && !list.contains(j)) list.add(j);
            }
      } else {
            for(int i : nums1){
                set.add(i);
            }
            
            for(int j : nums2){
                if(set.contains(j) && !list.contains(j) ) list.add(j);
            }
        }
        int[] res = new int[list.size()];
        int i=0;
       for(int l : list){
           res[i++] = l;
       }
        return res;
    }
	
}
