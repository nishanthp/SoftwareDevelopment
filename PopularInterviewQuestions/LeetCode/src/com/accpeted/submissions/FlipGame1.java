package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.List;

public class FlipGame1 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	List<String> allComb = new ArrayList<String>();
    public List<String> generatePossibleNextMoves(String s) {
        if(s == null || s.length() < 2) return allComb;
        generatePossibleNextMoves(s, 0);
        return allComb;
    }
    
    public void generatePossibleNextMoves(String s, int count) {
        if(count == 1) {
             if(!allComb.contains(s)) allComb.add(s);
             return;
        }
        for(int i=0; i<s.length();i++){
            if(s.startsWith("++", i)){
            String temp = s.substring(0,i) + "--" + s.substring(i+2);
            System.out.println(temp);
            generatePossibleNextMoves(temp, count+1);
            }         
        }
    }

}
