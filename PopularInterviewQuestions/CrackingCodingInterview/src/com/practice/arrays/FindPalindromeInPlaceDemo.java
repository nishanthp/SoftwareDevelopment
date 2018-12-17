package com.practice.arrays;

public class FindPalindromeInPlaceDemo {
	public static void main(String[] args) {
		String input = "abccaba";
		System.out.println(isPalindrome(input));

	}

	private static boolean isPalindrome(String input) {
		int left = 0;
		int right = input.length()-1;
		while (left < right) {
			if (input.charAt(left) != input.charAt(right)) {
				return false;
			}
			left++;
			right--;
		}
		return true;

	}
}
