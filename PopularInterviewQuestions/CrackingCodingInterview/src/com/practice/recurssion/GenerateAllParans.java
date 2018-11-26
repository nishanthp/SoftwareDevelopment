package com.practice.recurssion;

import java.util.HashSet;

public class GenerateAllParans {

	public static void main(String[] args) {
		int n = 2;
		HashSet<String> set = new HashSet<>();
		for (String s : generateParan(n)) {
			System.out.println(s);
		}
	}

	private static HashSet<String> generateParan(int n) {
		HashSet<String> set = new HashSet<>();
		if (n == 0) {
			set.add("");
			return set;
		} else {
			// we do not care about this, we want to capture it and then add as
			// n is different.
			HashSet<String> prev = generateParan(n - 1);
			for (String eachSet : prev) {
				for (int i = 0; i < eachSet.length(); i++) {
					if (eachSet.charAt(i) == '(') {
						set.add(insertInMiddle(eachSet, i));
					}
				}
				set.add("()" + eachSet);
			}
		}
		return set;
	}

	private static String insertInMiddle(String eachSet, int i) {
		String newString = eachSet.substring(0, i + 1) + "()" + eachSet.substring(i + 1, eachSet.length());
		return newString;
	}
}
