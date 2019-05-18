package com.revision.nthTime;

public class TopDownBottomUp {

	public static void main(String[] args) {
		int[] dp = new int[11];
		int sum = topDownFib(10, dp);
		System.out.println(sum);
		System.out.println(dp[0]);
		System.out.println(dp[1]);
		int sum2 = bottomUpFib(10);
		System.out.println(sum2);
	}
	
	// Below is top down with memo. You recursively call till the base case (leaf of a tree)
	// and then backtrack. 
	// Time complexity - O(n)
	// Space complexity - O(n)
	// Without memo, time complexity - O(2^n)
	
	public static int topDownFib(int n, int[] dp) {
		if(n == 0) {
			dp[n] = 0;
			return dp[n];
		};
		if(n == 1) {
			dp[n] = 1;
			return dp[n];
		}
		if(dp[n] != 0) return dp[n];
		dp[n] = topDownFib(n-1, dp) + topDownFib(n-2, dp);
		return dp[n];
	}
	
	// Below is the bottom up approach. You know the base cases (leaf of a tree),
	// you build on top of it.
	// Time complexity - O(n)
	// Space complexity - O(n)
	public static int bottomUpFib(int n) {
		int[] dp = new int[n+1];
		dp[0] = 0;
		dp[1] = 1;
		for(int i=2;i<=n;i++)
		{
			dp[i] = dp[i-1] + dp[i-2];
		}
		return dp[n];
	}
	
	

}
