package com.accpeted.submissions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class RepeatedDNASequence {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> mapCount = new HashMap<String, Integer>();
        List<String> result = new LinkedList<String>();
        int left = 0;
        int right = left+1; 
        int counter = 1;
        while(right < s.length()) {
            right+=1;
            counter+=1;
            while(counter == 10) {
                String temp = s.substring(left, right);
                mapCount.putIfAbsent(temp, 0);
                mapCount.put(temp, mapCount.get(temp)+1);
                counter-=1;
                left+=1;
            }
        }
        for(Entry<String, Integer> entry : mapCount.entrySet()){
            if(entry.getValue() > 1) result.add(entry.getKey());
        }
        return result;
    }

}
