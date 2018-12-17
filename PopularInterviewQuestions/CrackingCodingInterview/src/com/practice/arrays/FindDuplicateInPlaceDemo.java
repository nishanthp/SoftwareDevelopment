package com.practice.arrays;

public class FindDuplicateInPlaceDemo {
	public static void main(String[] args) {
		String input = "abcde";
		System.out.println(findDuplicate(input));
	}

	private static boolean findDuplicate(String input) {
		int checker = 0;
		for (int i = 0; i < input.length(); i++) {
			int charint = input.charAt(i) - 'a';
			int temp = 1 << charint;
			if ((checker & temp) == 0) {
				checker |= temp;
			} else
				return false;
		}
		return true;
	}
}
