package com.accpeted.submissions;

import java.util.HashMap;

public class PaintHouse2 {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	
	int minValue = 0;
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0) return 0;
        HashMap<String, Integer> dp = new HashMap<String, Integer>();
        return paintHouse(costs, 0, 0, dp);
    }
    
   public int paintHouse(int[][] costs, int rowIndex, int colIndex, HashMap<String, Integer> dp) {
    if(rowIndex > costs.length-1) return 0;
    
     
     if(dp.containsKey(rowIndex+"-"+ colIndex)) return dp.get(rowIndex+"-"+ colIndex);
     
     int minCost = Integer.MAX_VALUE;
     for(int i=0; i<costs[0].length;i++){
        if(rowIndex > 0 && colIndex == i) continue;
        int currCost = costs[rowIndex][i];
         int restOfCost  = paintHouse(costs, rowIndex+1, i, dp);
         minCost = Math.min(minCost, restOfCost+currCost);
     }
     dp.put(rowIndex+"-"+ colIndex, minCost);
     return minCost;
}

}
