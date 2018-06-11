package accpetedSubmissions;

public class ClimbingStairs {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int climbStairs(int n) {
		int[] dp = new int[n + 1];
		return countStairs(n, dp);
	}

	public int countStairs(int n, int[] dp) {
		if (n <= 0)
			return 0;
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (dp[n] != 0)
			return dp[n];
		return dp[n] = (countStairs(n - 1, dp) + countStairs(n - 2, dp));
	}

}
