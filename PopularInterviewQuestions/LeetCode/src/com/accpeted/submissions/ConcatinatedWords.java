package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConcatinatedWords {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> result = new ArrayList<String>();
        HashSet<String> set = new HashSet<String>(Arrays.asList(words));
        for(String word : words){
            if (wordBreak(word,0, 0, word.length()-1,set)) {
                result.add(word);
            }
        }
        return result;
    }
    
	// Time complexity - O(2^n-1). 
	// To find tc, start with string length = 0 , 1, 2 and draw the tree of each case, to get the
	// number of nodes.
     public boolean wordBreak(String word, int count, int start, int end, HashSet<String> set) {
         if(start > end && count > 1) return true;
         StringBuffer sb = new StringBuffer();
         for(int i=start;i<word.length();i++){
             String temp = sb.append(word.charAt(i)).toString();
             if (set.contains(temp)) {
                    if(wordBreak(word, count+1, i+1, end, set)) return true;
             }
         }
         return false;
     }

}
