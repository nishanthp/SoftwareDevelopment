package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MinimumIndexSum {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int i=0;i<list1.length;i++){
            map.put(list1[i],i);    
        }
        int minIndex = Integer.MAX_VALUE;
        for(int i=0;i<list2.length;i++){
            if(map.containsKey(list2[i])) {
                if(Math.abs(map.get(list2[i])+i) < minIndex){
                    minIndex = Math.abs(map.get(list2[i])+i);
                    result.add(0,list2[i]);
                    while(result.size()>1)result.remove(result.size()-1);
                }
                else if(Math.abs(map.get(list2[i])+i) == minIndex){
                    result.add(0,list2[i]);
                }
            }
        }
        return result.toArray(new String[result.size()]);
    }

}
