package com.java.concepts;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderLog {

	public static void main(String[] args) {
		// Ran on leetcode.
		String s1 = "qdflower";
		// String s2 = "fl";
		// System.out.println(s1.indexOf(s2));
		System.out.println(s1.substring(1));

	}

	public String[] reorderLogFiles(String[] logs) {
		Arrays.sort(logs, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				int s1Index = s1.indexOf(' ');
				int s2Index = s2.indexOf(' ');
				char s1c = s1.charAt(s1Index + 1);
				char s2c = s2.charAt(s2Index + 1);
				if (Character.isDigit(s1c) && Character.isDigit(s2c)) {
					return 0;
				}
				if (Character.isDigit(s1c))
					return 1;
				if (Character.isDigit(s2c))
					return -1;
				int compare = s1.substring(s1Index + 1)
						.compareTo(s2.substring(s2Index + 1));
				if (compare != 0)
					return compare;
				return s1.compareTo(s2);
			}
		});
		return logs;
	}

}
