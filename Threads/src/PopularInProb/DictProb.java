package PopularInProb;

import java.util.ArrayList;

public class DictProb {
	public static ArrayList<String> dict = new ArrayList<String>();
	public static ArrayList<String> meaningFullWords = new ArrayList<String>();

	public static void main(String[] args) {
		dict.add("Hello");
		dict.add("World");
		dict.add("is");
		String input = "HelloWorld";
		ArrayList<String> result = getMeaningfulWords(input, "", 0, 0);
		System.out.println(result.get(0));
		System.out.println(result.get(1));
		/// System.out.println(result.get(3));
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
}
