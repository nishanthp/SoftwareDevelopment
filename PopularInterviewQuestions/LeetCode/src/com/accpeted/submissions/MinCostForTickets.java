package com.accpeted.submissions;

import java.util.HashSet;

public class MinCostForTickets {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[366]; // 365 days
        HashSet<Integer> set = new HashSet<Integer>();
        for(int eDay : days){
            set.add(eDay);
        }
        for(int i=1;i<dp.length;i++){
            if(!set.contains(i)) {
                dp[i] = dp[i-1];
                continue;
            }
            if(i > days[days.length-1]) break;
                dp[i] = dp[i-1]+costs[0]; // store the 1 day costs and compare.
                dp[i] = Math.min(dp[i], costs[1]+dp[Math.max(0,i-7)]);
                dp[i] = Math.min(dp[i], Math.min(costs[1]+dp[Math.max(0,i-7)], costs[2]+dp[Math.max(0, i-30)]));
        }
        return dp[days[days.length-1]];
    }

}
