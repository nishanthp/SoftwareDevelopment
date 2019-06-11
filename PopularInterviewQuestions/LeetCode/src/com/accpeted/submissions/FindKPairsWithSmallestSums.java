package com.accpeted.submissions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

	public static void main(String[] args) {
		// Ran on leetcode
		HashSet<Integer> fner = new HashSet<>();
		Iterator<Integer> hashIt = fner.iterator();

	}
	
	
	public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;
        PriorityQueue<Integer[]> queue = new PriorityQueue<Integer[]>(new Comparator<Integer[]>(){
            @Override 
            public int compare(Integer[] n1, Integer[] n2){
                return n1[0] + n1[1] - n2[0] - n2[1];
            }
        });
        for(int i=0 ;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                queue.offer(new Integer[]{nums1[i], nums2[j]});
            }
        }
        for(int i=k;i>0;i--){            
            if(!queue.isEmpty()) result.add(Arrays.asList(queue.poll()));
        }
        return result;
    }

}
