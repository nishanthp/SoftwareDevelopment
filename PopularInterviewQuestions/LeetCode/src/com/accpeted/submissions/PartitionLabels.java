package com.accpeted.submissions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public List<Integer> partitionLabels(String S) {
        if(S == null || S.length() == 0) return null;
        int left=0;
        int right=0;
        int counter=0;
        List<Integer> result = new LinkedList<Integer>();
        HashSet<Character> charSet = new HashSet<Character>();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i=0;i<S.length();i++){
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0)+1);
        }
        while(right<S.length()){
            if(!charSet.contains(S.charAt(right))) {
                counter++;
                charSet.add(S.charAt(right));
            }
            
            map.put(S.charAt(right), map.get(S.charAt(right))-1);     
            if(map.get(S.charAt(right)) == 0) {
                counter--;
                map.remove(S.charAt(right));
            }
            right++;
            if(counter == 0) {
                result.add(right-left);
                left=right;
            }
        }
        return result;
    }

}
