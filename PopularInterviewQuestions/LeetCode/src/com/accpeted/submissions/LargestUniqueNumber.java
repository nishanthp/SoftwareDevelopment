package com.accpeted.submissions;

import java.util.HashMap;
import java.util.Map;

public class LargestUniqueNumber {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    public int largestUniqueNumber(int[] A) {
        int result = -1;
        for(int each : A){
            map.put(each, map.getOrDefault(each,0)+1);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(entry.getValue() == 1) result = Math.max(result, entry.getKey());
        }
        return result;
    }

}
