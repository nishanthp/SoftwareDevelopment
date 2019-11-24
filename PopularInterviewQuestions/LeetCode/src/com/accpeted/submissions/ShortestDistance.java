package com.accpeted.submissions;

public class ShortestDistance {

	public static void main(String[] args) {
		// GeeksforGeeks.
		String input = "geeksforgeeks";
		char ref = 'g';
		int[] result = new int[input.length()];

		int prevPos = Integer.MAX_VALUE;
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == ref)
				prevPos = i;
			result[i] = i - prevPos;
		}

		prevPos = Integer.MAX_VALUE;
		for (int i = input.length() - 1; i >= 0; i--) {
			if (input.charAt(i) == ref)
				prevPos = i;
			result[i] = Math.min(result[i], prevPos - i);
		}

		for (int i : result) {
			System.out.println(i);
		}

	}

}
