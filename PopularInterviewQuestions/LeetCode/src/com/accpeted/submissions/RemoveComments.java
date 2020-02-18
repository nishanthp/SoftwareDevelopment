package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class RemoveComments {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public List<String> removeComments(String[] source) {
		List<String> result = new LinkedList<String>();
		boolean multiComment = false;
		StringBuffer sb = null;
		for (String each : source) {
			if (!multiComment) {
				sb = new StringBuffer();
			}
			for (int i = 0; i < each.length();) {
				if (multiComment && each.charAt(i) == '*'
						&& i + 1 < each.length() && each.charAt(i + 1) == '/') {
					multiComment = false;
					i++;
				} else if (!multiComment && each.charAt(i) == '/'
						&& i + 1 < each.length() && each.charAt(i + 1) == '/') {
					break;
				} else if (!multiComment && each.charAt(i) == '/'
						&& i + 1 < each.length() && each.charAt(i + 1) == '*') {
					multiComment = true;
					i++;
				} else if (!multiComment)
					sb.append(each.charAt(i));
				i++;
			}
			if (!multiComment && sb.length() > 0) {
				result.add(sb.toString());
			}
		}
		return result;
	}

}
