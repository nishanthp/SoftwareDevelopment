package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumDesign {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	class TwoSum {
	// Same as before. However, consider the below ex:
	//0,-1, 1 and the target is 0. The result pair is [1,-1].
	HashMap<Integer, List<Integer>> map;
    int currIndex = 0;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap<Integer,List<Integer>>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
       if(!map.containsKey(number)){
           List<Integer> temp = new ArrayList<Integer>();
           temp.add(currIndex);
           currIndex++;
           map.put(number, temp);
           return;
       } 
        List<Integer> t = map.get(number);
        t.add(currIndex);
        System.out.println(t.size());
        map.put(number, t);
        currIndex++;
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            int otherVal = value - entry.getKey();
            if(otherVal == entry.getKey()) {
                if(entry.getValue().size() > 1) return true;
            } else if(map.containsKey(otherVal)) return true;
        }
        return false;
    }
	}

}
