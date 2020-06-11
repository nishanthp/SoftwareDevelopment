package com.common.templates;

public class Knapsack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int target = 12;
		int[] pages = {100, 32, 45};
		int[] weight = {5, 7, 2};
		Integer[][] dp = new Integer[pages.length][target + 1];
		int max = boundedKnapsack(pages, weight, target, 0, dp);
		int umax = UnboundedKnapsack(pages, weight, target, 0, dp);
		System.out.println(max);
		System.out.println(umax);
	}

	// O(2^(n))
	private static int boundedKnapsack(int[] pages, int[] weight,
			int runningSum, int currIndex, Integer[][] dp) {
		if (currIndex >= pages.length)
			return 0;
		if (runningSum < 0) {
			return 0;
		}
		if (runningSum == 0)
			return 1;
		if (dp[currIndex][runningSum] != null)
			return dp[currIndex][runningSum];
		int include = 0;
		if (weight[currIndex] < runningSum) {
			include = boundedKnapsack(pages, weight,
					runningSum - weight[currIndex], currIndex + 1, dp)
					+ pages[currIndex];
		}
		int exclude = boundedKnapsack(pages, weight, runningSum, currIndex + 1,
				dp);
		dp[currIndex][runningSum] = Math.max(include, exclude);
		return dp[currIndex][runningSum];

	}

	// O(2^(n+c))
	private static int UnboundedKnapsack(int[] pages, int[] weight,
			int runningSum, int currIndex, Integer[][] dp) {
		if (currIndex >= pages.length)
			return 0;
		if (runningSum < 0)
			return 0;
		if (runningSum == 0)
			return 1;
		if (dp[currIndex][runningSum] != null)
			return dp[currIndex][runningSum];
		int include = 0;
		if (weight[currIndex] < runningSum) {
			include = boundedKnapsack(pages, weight,
					runningSum - weight[currIndex], currIndex, dp)
					+ pages[currIndex];
		}
		int exclude = boundedKnapsack(pages, weight, runningSum, currIndex + 1,
				dp);
		dp[currIndex][runningSum] = Math.max(include, exclude);
		return dp[currIndex][runningSum];

	}

}
