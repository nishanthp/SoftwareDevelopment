package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestWordDistance2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	HashMap<String, List<Integer>> wordMap = new HashMap<String, List<Integer>>();
    public void WordDistance(String[] words) {
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
    }
    
    public int shortest(String word1, String word2) {
        List<Integer>  word1Indexes = wordMap.get(word1);
        List<Integer> word2Indexes = wordMap.get(word2);
        int i=0;
        int j=0;
        int minDistance = Integer.MAX_VALUE;
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
