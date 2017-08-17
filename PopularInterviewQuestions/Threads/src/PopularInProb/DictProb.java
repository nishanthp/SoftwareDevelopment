package PopularInProb;

import java.util.ArrayList;

public class DictProb {
	public static ArrayList<String> dict = new ArrayList<String>();
	public static ArrayList<String> meaningFullWords = new ArrayList<String>();

	public static void main(String[] args) {
		dict.add("Hello");
		dict.add("World");
		dict.add("is");
		String input = "HelloWorldis";
		/*
		 * ArrayList<String> result = getMeaningfulWords(input, "", 0, 0);
		 * System.out.println(result.get(0)); System.out.println(result.get(1));
		 */
		/// System.out.println(result.get(3));

		String res = DictProb.wordBreak(input.toCharArray(), 0);
		System.out.println(res);

	}

	public static ArrayList<String> getMeaningfulWords(String input, String wordSoFar, int outerIndex, int innerIndex) {
		if (outerIndex >= input.length() || innerIndex >= input.length()) {
			return meaningFullWords;
		}
		for (int i = outerIndex; i < input.length(); i++) {
			String eachChar = Character.toString(input.charAt(innerIndex));
			wordSoFar = wordSoFar + eachChar;
			if (dict.contains(wordSoFar)) {
				meaningFullWords.add(wordSoFar);
				getMeaningfulWords(input, "", outerIndex + 1, outerIndex + 1);
			} else {
				getMeaningfulWords(input, wordSoFar, outerIndex, innerIndex + 1);
			}
			wordSoFar = "";
			outerIndex++;
			innerIndex = outerIndex;

		}
		return meaningFullWords;
	}

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
				meaningFullWords.add(buffer.toString());
				String result = wordBreak(input, i + 1);
				if (result != null) {
					return buffer.toString() + " " + result;
				} else
					return buffer.toString();
			}
		}
		if (dict.contains(buffer.toString())) {
			return buffer.toString();
		}
		return null;
	}
}
