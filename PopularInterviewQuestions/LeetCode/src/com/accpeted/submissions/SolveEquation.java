package com.accpeted.submissions;

import java.util.PriorityQueue;

public class SolveEquation {

	public static void main(String[] args) {
	    // Ran on leetcode.
		PriorityQueue<int[]> sofje= new PriorityQueue<int[]>();
		sofje.offer(new int[] {1,2,3});
	}

	public String solveEquation(String equation) {
        String[] parts = equation.split("=");
        Node14 leftSide = evaluate(parts[0]);
        Node14 rightSide = evaluate(parts[1]);
        int x = leftSide.xVal - rightSide.xVal;
        int number = rightSide.numVal - leftSide.numVal;
        if(x == 0) {
            if(number == 0) return "Infinite solutions";
            return "No solution";
            
        }
        int res = number/x;
        StringBuilder sb = new StringBuilder();
        sb.append("x=").append(res);
        return sb.toString();
    }
    
    
     public Node14 evaluate(String input) {
         if(input.length() == 0) return null;
         String[] tokens = input.split("(?=[+-])");
         Node14 eqVal = new Node14();
         for(String token : tokens){
             if(token.contains("+x")) eqVal.xVal += 1;
             else if(token.contains("-x")) eqVal.xVal -= 1;
             else if(token.contains("x")) {
                 if (token.substring(0, token.indexOf("x")).length() == 0) {
                      eqVal.xVal += 1;
                 } else {
                      eqVal.xVal += Integer.valueOf(token.substring(0, token.indexOf("x")));
                 }
             }
             else 
                 eqVal.numVal += Integer.valueOf(token);
         }
         return eqVal;
     }
	class Node14 {
	    int xVal;
	    int numVal;
	}

	}

