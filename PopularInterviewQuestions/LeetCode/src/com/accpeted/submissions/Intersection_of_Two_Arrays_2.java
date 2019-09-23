package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Intersection_of_Two_Arrays_2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num : nums1){
            map.putIfAbsent(num, 0);
            map.put(num, map.get(num)+1);
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int num : nums2) {
            if(map.containsKey(num)){
                list.add(num);
                map.put(num, map.get(num)-1);
                if(map.get(num) == 0) map.remove(num);
            }
        }
        int[] result = new int[list.size()];
        int i=0;
        for(int res : list){
            result[i++] = res;
        }
         return result;
    }
}
