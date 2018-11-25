package recurssion;

import java.util.HashMap;
import java.util.Map.Entry;

public class AllPermsDuplicate {
	public static void main(String[] args) {
		HashMap<Character, Integer> count = new HashMap<>();
		String input = "aabbcc";
		populateMap(count, input);
		printPerms(count, input.length(), "");
	}

	private static void populateMap(HashMap<Character, Integer> count, String input) {
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (count.containsKey(c)) {
				count.put(c, count.get(c) + 1);
			} else {
				count.put(c, 1);
			}
		}

	}

	private static void printPerms(HashMap<Character, Integer> count, int remaining, String prefix) {
		if (remaining == 0) {
			System.out.println(prefix);
		}

		for (Entry<Character, Integer> eachEntry : count.entrySet()) {
			if (eachEntry.getValue() > 0) {
				count.put(eachEntry.getKey(), eachEntry.getValue() - 1);
				printPerms(count, remaining-1, prefix + eachEntry.getKey());
				count.put(eachEntry.getKey(), eachEntry.getValue() + 1);
			}
		}
	}
}
