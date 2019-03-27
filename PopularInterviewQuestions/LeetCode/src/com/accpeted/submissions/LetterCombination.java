package com.accpeted.submissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LetterCombination {

	public static void main(String[] args) {
		// Ran on leetcode
	}
	
	List<String> result = new LinkedList<String>();
    public List<String> letterCombinations(String digits) {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        return findAllPossibleComb(digits, map, 0);
        
        
    }
    
    public List<String> findAllPossibleComb(String digits, HashMap<String, String> map, int start){
        List<String> curA = new LinkedList<String>();
        if(start > digits.length()-1) return curA;            
            List<String> prev = findAllPossibleComb(digits, map, start+1); 
            String curr = map.getOrDefault(digits.charAt(start)+"", "");
             System.out.println(start);
            if (prev.size() == 0) {
                for(int j=0;j<curr.length();j++){
                String cString = curr.charAt(j)+"";
                    curA.add(cString);    
                     
            }
            } else {
                for(int j=0;j<curr.length();j++){
                    String cString = curr.charAt(j)+"";
                    for(String each : prev) {
                        curA.add(cString+each);
                    }
            }
            }
        return curA;
    }

}
