package arrays;

import java.util.Arrays;

public class FindTheShortedtSubStringDemo {

	public static void main(String[] args) {
		String input = "aabbccba";
		String reqString = "abc";
		System.out.println(findShortestSubString(input, reqString));

	}

	private static String findShortestSubString(String input, String reqString) {
		String sortedReqString = sortString(reqString);
		String tempStr = null;
		for (int m = 0; m < input.length(); m++) {
			if (m + 3 >= input.length()) {
				tempStr = input.substring(m);
				if (sortString(tempStr).equals(sortedReqString)) {
					return tempStr;
				}
			} else {
				tempStr = input.substring(m, m + 3);
				if (sortString(tempStr).equals(sortedReqString)) {
					return tempStr;
				}
			}
		}
		return tempStr;

	}

	public static String sortString(String input) {
		char[] tempinput = input.toCharArray();
		Arrays.sort(tempinput);
		return new String(tempinput);
	}

}
