package com.accpeted.submissions;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class WordLadder {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Works fine. Time limit exceeded because dict provided was a list. Convert it to 
		// hash set like the below line, it works for large cases too.
		HashSet<String> wordSet = new HashSet<String>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        int level = 0;
        Deque<String> queue = new LinkedList<String>();
        HashSet<String> visited = new HashSet<String>();
        queue.add(beginWord);
        visited.add(beginWord);
        level += 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                String currWord = queue.remove();
                for(int l=0;l<currWord.length();l++){
                    char[] charArray = currWord.toCharArray();
                    for(char ch='a'; ch<='z';ch++){
                        charArray[l] = ch;
                        String potentialNeighbor = String.valueOf(charArray);
                        if (potentialNeighbor.equals(endWord)) {
                            return level+=1;
                        }
                        if(wordSet.contains(potentialNeighbor) && !visited.contains(potentialNeighbor)) {
                            visited.add(potentialNeighbor);
                            queue.add(potentialNeighbor);
                        }
                    }
                    
                }
            }
            level += 1;
        }
        return 0;
    }

}
