package com.accpeted.submissions;

import java.util.HashMap;
import java.util.Map;

public class CompareStringByFreq {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		Map<String, Integer> wMap = new HashMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			wMap.put(String.valueOf(i) + " " + words[i],
					smallestCharFreq(words[i]));
		}
		int[] result = new int[queries.length];
		int i = 0;
		for (String query : queries) {
			int count = smallestCharFreq(query);
			int higherCount = 0;
			for (Map.Entry<String, Integer> entry : wMap.entrySet()) {
				if (entry.getValue() > count)
					higherCount += 1;
			}
			result[i++] = higherCount;
		}
		return result;
	}

	private int smallestCharFreq(String word) {
		int[] charFreq = new int[256];
		for (char each : word.toCharArray()) {
			charFreq[each - 'A'] += 1;
		}
		for (int i = 0; i < charFreq.length; i++) {
			if (charFreq[i] > 0)
				return charFreq[i];
		}
		return 0;
	}

}
