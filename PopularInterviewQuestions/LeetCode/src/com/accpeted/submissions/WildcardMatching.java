package com.accpeted.submissions;

public class WildcardMatching {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public boolean isMatch(String s, String p) {
		char[] input = s.toCharArray();
		char[] pattern = p.toCharArray();

		// Convert the pattern to having a single *, if there are multiple.
		int patternIndex = 0;
		boolean isFirst = true;
		for (int i = 0; i <= pattern.length - 1; i++) {
			if (pattern[i] == '*') {
				if (isFirst) {
					pattern[patternIndex++] = pattern[i];
					isFirst = false;
				}
			} else {
				pattern[patternIndex++] = pattern[i];
				isFirst = true;
			}
		}

		boolean[][] matrix = new boolean[input.length + 1][patternIndex + 1];
		// initial values. Both are empty strings.
		matrix[0][0] = true;
		if (patternIndex > 0 && pattern[0] == '*') {
			matrix[0][1] = true;
		}

		for (int i = 1; i <= matrix.length - 1; i++) {
			for (int j = 1; j <= matrix[0].length - 1; j++) {
				if (input[i - 1] == pattern[j - 1] || pattern[j - 1] == '?') {
					matrix[i][j] = matrix[i - 1][j - 1];
				} else if (pattern[j - 1] == '*') {
					matrix[i][j] = matrix[i - 1][j] || matrix[i][j - 1];
				}
			}
		}
		return matrix[input.length][patternIndex];
	}
}
