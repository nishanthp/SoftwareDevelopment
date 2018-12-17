package com.accpeted.submissions;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int firstUniqChar(String s) {
		// Store it in a char array
		int[] store = new int[256];
		for (char eachChar : s.toCharArray()) {
			store[(int) eachChar] += 1;
		}

		// find the first non repeating char
		for (int i = 0; i <= s.length() - 1; i++) {
			if (store[(int) s.charAt(i)] == 1)
				return i;
		}
		return -1;
	}
}
