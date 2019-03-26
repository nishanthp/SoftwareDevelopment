package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

	public static void main(String[] args) {
		// Ran on leetcode
	}
	
	List<String> result = new LinkedList<String>();
    public List<String> generateParenthesis(int n) {
        return generate(n);
    }
    
    public List<String> generate(int n) {
        if(n == 0) return result; 
        List<String> curr = new LinkedList<String>();
            List<String> prev = generate(n-1);
            if(prev.size() == 0){
                curr.add("()");
            } else {
                StringBuilder sb = new StringBuilder();
                for(int k=0;k<prev.size();k++){
                    String temp = prev.get(k);
                    for(int j=0;j<temp.length();j++){
                       if(temp.charAt(j) == '(') {
                         sb.append(temp.substring(0,j+1)).append("()").append(temp.substring(j+1));
                         if (!curr.contains(sb.toString()))curr.add(sb.toString());
                         sb.setLength(0);
                       }
                    }
                }
                StringBuilder sbt = new StringBuilder();
                for(int i=0;i<n;i++) {
                    sbt.append("()");
                }
                curr.add(sbt.toString());
            }
        return curr;
    }

}
