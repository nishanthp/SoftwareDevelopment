package MSFT;

import java.util.HashSet;

public class FindAllPalindromesDemo {
	public static void main(String[] args) {
		String input = "google";

		for (String input1 : findAllPalindromes(input)) {
			System.out.println(input1);
		}
	}

	private static HashSet<String> findAllPalindromes(String input) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < input.length(); i++) {
			// odd palindromes
			expandBothSides(input, i, i, set);
			// even palindromes
			expandBothSides(input, i, i + 1, set);
		}
		return set;
	}

	private static void expandBothSides(String input, int low, int high, HashSet<String> set) {
		while (low >= 0 && high < input.length()) {
			if (input.charAt(low) == input.charAt(high)) {
				set.add(input.substring(low, high + 1));
				low--;
				high++;
			} else
				break;
		}
	}
}
