package com.accpeted.submissions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class MostCommonWord {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> set = new HashSet<String>(Arrays.asList(banned));
        String[] words = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String result = null;
        for(String word : words){
            if(!set.contains(word)) {
                if(!map.containsKey(word)) map.put(word, 1);
                else 
                    map.put(word, map.get(word)+1);
            }
        }

        for(Entry<String, Integer> entry : map.entrySet()){
            if(result == null || entry.getValue() > map.get(result)) result = entry.getKey();
        }
        return result;
    }

}
