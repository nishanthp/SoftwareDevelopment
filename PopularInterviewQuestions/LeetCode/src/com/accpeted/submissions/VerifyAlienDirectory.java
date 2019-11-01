package com.accpeted.submissions;

public class VerifyAlienDirectory {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean isAlienSorted(String[] words, String order) {
		if (words.length <= 1)
			return true;
		for (int i = 1; i < words.length; i++) {
			String firstWord = words[i - 1];
			String secondWord = words[i];
			if (firstWord.length() > secondWord.length() && firstWord
					.substring(0, secondWord.length()).equals(secondWord)) {
				return false;
			}
			if (firstWord.length() == secondWord.length()
					&& firstWord.equals(secondWord))
				continue;
			for (int j = 0; j < firstWord.length(); j++) {
				if (firstWord.charAt(j) == secondWord.charAt(j))
					continue;
				if (order.indexOf(firstWord.charAt(j)) > order
						.indexOf(secondWord.charAt(j))) {
					return false;
				} else
					break;
			}
		}
		return true;
	}

}
