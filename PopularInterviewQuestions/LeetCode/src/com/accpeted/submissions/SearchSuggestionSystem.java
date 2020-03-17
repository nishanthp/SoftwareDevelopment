package com.accpeted.submissions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchSuggestionSystem {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public List<List<String>> suggestedProducts(String[] products,
			String searchWord) {
		List<List<String>> result = new LinkedList<>();
		StringBuffer sb = new StringBuffer();
		Arrays.sort(products);
		for (Character c : searchWord.toCharArray()) {
			sb.append(c);
			List<String> curr = new LinkedList<String>();
			int currCount = 0;
			String temp = sb.toString();
			int length = temp.length();
			for (String product : products) {
				// Below line is important. Use this instead of string.contains.
				if (product.length() >= length
						&& product.substring(0, length).equals(temp)
						&& currCount < 3) {
					curr.add(product);
					currCount += 1;
				}
			}
			result.add(curr);
		}

		return result;
	}

}
