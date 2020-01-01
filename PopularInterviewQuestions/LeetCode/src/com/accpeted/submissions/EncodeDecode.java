package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public String encode(List<String> strs) {
		StringBuffer sb = new StringBuffer();
		for (String each : strs) {
			sb.append(each.length()).append("/").append(each);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	// Decodes a single string to a list of strings.
	public List<String> decode(String s) {
		List<String> result = new ArrayList<String>();
		int i = 0;
		while (i < s.length()) {
			int delimiterIndex = s.indexOf("/");
			int slength = Integer.valueOf(s.substring(i, delimiterIndex));
			i = slength + delimiterIndex + 1;
			result.add(s.substring(delimiterIndex + 1, i));
			s = s.substring(i, s.length());
			i = 0;
		}
		return result;
	}

}
