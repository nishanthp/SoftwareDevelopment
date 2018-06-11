package popularInProb;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DictProb {
	public static ArrayList<String> dict = new ArrayList<String>();
	public static ArrayList<String> meaningFullWords = new ArrayList<String>();

	public static void main(String[] args) {
		dict.add("cats");
		dict.add("and");
		dict.add("dogs");
		String input = "catsanddogsis";
		/*
		 * ArrayList<String> result = getMeaningfulWords(input, "", 0, 0);
		 * System.out.println(result.get(0)); System.out.println(result.get(1));
		 */
		/// System.out.println(result.get(3));

		String res = DictProb.wordBreak(input.toCharArray(), 0);
		System.out.println(res);
		/*
		 * Set<String> dictonary = new HashSet<>(); dictonary.add("cats");
		 * dictonary.add("dogs"); dictonary.add("si"); boolean res =
		 * DictProb.wordBreak(input, dictonary); System.out.println(res);
		 */

	}

	// most popular answer. Wont get the words though.
	public static boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0)
			return false;

		int n = s.length();

		// dp[i] represents whether s[0...i] can be formed by dict
		boolean[] dp = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);

				if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[n - 1];
	}

	/*
	 * public static ArrayList<String> getMeaningfulWords(String input, String
	 * wordSoFar, int outerIndex, int innerIndex) { if (outerIndex >=
	 * input.length() || innerIndex >= input.length()) { return
	 * meaningFullWords; } for (int i = outerIndex; i < input.length(); i++) {
	 * String eachChar = Character.toString(input.charAt(innerIndex)); wordSoFar
	 * = wordSoFar + eachChar; if (dict.contains(wordSoFar)) {
	 * meaningFullWords.add(wordSoFar); getMeaningfulWords(input, "", outerIndex
	 * + 1, outerIndex + 1); } else { getMeaningfulWords(input, wordSoFar,
	 * outerIndex, innerIndex + 1); } wordSoFar = ""; outerIndex++; innerIndex =
	 * outerIndex;
	 * 
	 * } return meaningFullWords; }
	 */

	/**
	 * This is better than the previous one.
	 * 
	 * @param input
	 *            in the form of char array.
	 * @param low
	 *            starting index of a potential word.
	 * @return dict words broken down in the string.
	 */
	public static String wordBreak(char[] input, int low) {
		StringBuffer buffer = new StringBuffer();
		for (int i = low; i < input.length; i++) {
			buffer.append(input[i]);
			if (dict.contains(buffer.toString())) {
				String result = wordBreak(input, i + 1);
				if (result != null) {
					return buffer.toString() + " " + result;
				} else
					return buffer.toString();
			}
		}
		return null;
	}

}
