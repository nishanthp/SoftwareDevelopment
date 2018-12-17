package com.accpeted.submissions;

public class BuySell2 {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	//Same as buySell 1. But adding all the positive diff.
	public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int[] interm = new int[prices.length];
        interm[0]=0;
        int maxCur = 0;
        int maxSoFar = 0;
        for(int i=1;i<prices.length;i++){
            interm[i] =prices[i] - prices[i-1];
            maxCur += Math.max(0,interm[i]);
        }
        return maxCur;
    }

}
