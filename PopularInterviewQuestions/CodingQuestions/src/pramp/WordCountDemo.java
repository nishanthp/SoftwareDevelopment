package pramp;

import java.util.HashMap;
import java.util.Map.Entry;

public class WordCountDemo {
	public static void main(String[] args) {
		String input = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
		WordCountDemo d = new WordCountDemo();
		String[][] res = d.wordCount(input);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[0].length; j++) {
				System.out.println(res[i][j]);
			}
		}
	}

	public String[][] wordCount(String input) {
		HashMap<String, Integer> map = new HashMap<>();
		String[] inputArray = input.split(" ");
		for (String eachWord : inputArray) {
			eachWord = eachWord.toLowerCase();
			count(eachWord, map);
		}
		return populateResult(map);

	}

	public String[][] populateResult(HashMap<String, Integer> map) {
		String[][] result = new String[map.size()][2];
		int i = 0;
		int j = 0;
		for (Entry<String, Integer> entry : map.entrySet()) {
			result[i][0] = entry.getKey();
			result[j][1] = entry.getValue().toString();
			i++;
			j++;
		}
		return result;
	}

	public void count(String eachWord, HashMap<String, Integer> map) {
		StringBuffer buffer = new StringBuffer();
		for (char c : eachWord.toCharArray()) {
			if (c >= 'a' && c <= 'z') {
				buffer.append(c);
			}
		}
		String newWord = buffer.toString();
		if (!map.containsKey(newWord)) {
			map.put(newWord, 1);
		} else {
			map.put(newWord, map.get(newWord) + 1);
		}
	}
}
