package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BuddyString {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean buddyStrings(String A, String B) {
		if (A.length() == 0 || B.length() == 0)
			return false;
		if (A.equals(B)) {
			Set<Character> set = new HashSet<Character>();
			for (char c : A.toCharArray()) {
				set.add(c);
			}
			if (set.size() < A.length())
				return true;
		}
		List<Integer> diff = new ArrayList<Integer>();
		for (int i = 0; i < A.length(); i++) {
			if (A.charAt(i) != B.charAt(i))
				diff.add(i);
		}
		if (diff.size() == 2) {
			if (A.charAt(diff.get(0)) == B.charAt(diff.get(1))
					&& A.charAt(diff.get(1)) == B.charAt(diff.get(0)))
				return true;
		}
		return false;
	}

}
