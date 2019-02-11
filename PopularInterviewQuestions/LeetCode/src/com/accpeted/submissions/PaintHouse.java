package com.accpeted.submissions;

public class PaintHouse {

	public static void main(String[] args) {
		// TODO Ran on leetcode.

	}
	
	 public int minCost(int[][] costs) {
	        if(costs.length == 0) return 0;
	        int lastR = costs[0][0];
	        int lastB = costs[0][1];
	        int lastG = costs[0][2];
	        
	        for(int i=1;i<costs.length;i++){
	            int curR = costs[i][0] + Math.min(lastB, lastG);
	            int curB = costs[i][1] + Math.min(lastR, lastG);
	            int curG = costs[i][2] + Math.min(lastR, lastB);
	            lastR=curR;
	            lastG=curG;
	            lastB=curB;
	            System.out.println(lastR) ;
	        }
	        return Math.min(lastR, Math.min(lastG, lastB));
	    }

}
