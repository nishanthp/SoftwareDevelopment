package com.accpeted.submissions;

public class NumberOfSegments {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int countSegments(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int count = 0;
		for (String each : s.split(" ")) {
			if (each != null && each.length() > 0)
				count++;

		}
		return count;
	}

}
