package com.accpeted.submissions;

public class ShortestDistanceToChar {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int[] shortestToChar(String S, char C) {
		int[] result = new int[S.length()];
		int lastSeenC = -S.length();
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == C) {
				lastSeenC = i;
			}
			result[i] = i - lastSeenC;
		}

		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) == C) {
				lastSeenC = i;
			}
			result[i] = Math.min(result[i], Math.abs(i - lastSeenC));
		}
		return result;
	}

}
