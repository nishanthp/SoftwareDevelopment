package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance3 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public int shortestWordDistance(String[] words, String word1, String word2) {
        HashMap<String, List<Integer>> wordMap = new HashMap<String, List<Integer>>();
        for(int i=0;i<words.length;i++) {
            if(!wordMap.containsKey(words[i])) {
                List<Integer> temp = new ArrayList<Integer>();
                temp.add(i);
                wordMap.put(words[i],temp);
            } else {
                List<Integer> temp = wordMap.get(words[i]);
                temp.add(i);
                wordMap.put(words[i], temp);
            }
        }
        int minDistance = Integer.MAX_VALUE;    
        if (word1.equals(word2)) {
            List<Integer>  word1Indexes = wordMap.get(word1);
            int left = 0;
            int right = left+1;
            while(right < word1Indexes.size()) {
                int currDistance = word1Indexes.get(right)-word1Indexes.get(left);
                minDistance = Math.min(minDistance, currDistance);
                left++;
                right++;
            }
            
            return  minDistance;  
        } 
        List<Integer>  word1Indexes = wordMap.get(word1);
        List<Integer> word2Indexes = wordMap.get(word2);
        int i=0;
        int j=0;
        while(i<word1Indexes.size() && j < word2Indexes.size()){
            int index1 = word1Indexes.get(i);
            int index2 = word2Indexes.get(j);
            // important is how to get all the difference. See how i and j increments. 
            if(index1 < index2) {
                minDistance = Math.min(minDistance, index2-index1); 
                i++;
            } else {
                minDistance = Math.min(minDistance, index1-index2); 
                j++;
            }
        }
        return minDistance;
    }

}
