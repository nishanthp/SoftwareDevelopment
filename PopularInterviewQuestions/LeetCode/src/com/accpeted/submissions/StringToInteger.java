package com.accpeted.submissions;

public class StringToInteger {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int myAtoi(String str) {
		if (str.length() == 0)
			return 0;
		boolean neg = false;
		int i = 0;
		while (i < str.length() && str.charAt(i) == ' ') {
			i++;
		}
		str = str.substring(i, str.length());
		if (str.length() > 0 && str.charAt(0) == '-') {
			neg = true;
			str = str.substring(1, str.length());
		}
		if (str.length() > 0 && str.charAt(0) == '+') {
			if (neg)
				return 0;
			str = str.substring(1, str.length());
		}
		if (str.length() == 0 || !Character.isDigit(str.charAt(0)))
			return 0;
		i = 0;
		while (i < str.length() && Character.isDigit(str.charAt(i))) {
			i++;
		}
		str = str.substring(0, i);
		StringBuffer sb = new StringBuffer();
		for (int j = 0; j < str.length(); j++) {
			sb.append(str.charAt(j));
		}
		String result = sb.toString();
		if (neg) {
			result = "-" + result;
		}
		int resultInt = 0;
		try {
			resultInt = Integer.valueOf(result);
		} catch (Exception ex) {
			if (neg)
				return Integer.MIN_VALUE;
			return Integer.MAX_VALUE;
		}
		return resultInt;
	}
}
