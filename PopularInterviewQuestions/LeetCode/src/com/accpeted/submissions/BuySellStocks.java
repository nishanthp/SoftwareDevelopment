package com.accpeted.submissions;

public class BuySellStocks {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Go from left to right, add all the positive differences.
	public int maxProfit(int[] prices) {
        int maxCur = 0;
        int maxSoFar = 0;
        for(int i=1;i<prices.length;i++){
            maxCur +=prices[i] - prices[i-1];
            maxCur = Math.max(0,maxCur);
            maxSoFar = Math.max(maxSoFar, maxCur);
        }
        return maxSoFar;
}

}
