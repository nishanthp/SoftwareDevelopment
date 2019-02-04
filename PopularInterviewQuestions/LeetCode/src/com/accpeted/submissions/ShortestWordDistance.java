package com.accpeted.submissions;

public class ShortestWordDistance {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int shortestDistance(String[] words, String word1, String word2) {
        int firstPtr = -1;
        int secondPtr = -1;
        int minDistance = Integer.MAX_VALUE;
        // keeping the same pointer is the key 
        for(int i=0;i<words.length;i++){
            if(words[i].equals(word1)){             
                    firstPtr = i;   
            }else if (words[i].equals(word2)){
                    secondPtr = i;
             }
            // calculating the min distance for each iteration is the key.
            if(firstPtr != -1 && secondPtr != -1) minDistance = Math.min(minDistance, Math.abs(firstPtr-secondPtr));
        }
        return minDistance;
    }

}
