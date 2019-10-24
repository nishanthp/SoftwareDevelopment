package com.accpeted.submissions;

public class ExcelSheet {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public String convertToTitle(int n) {
		StringBuffer buffer = new StringBuffer();
		while (n > 0) {
			buffer.append((char) (65 + (n - 1) % 26));
			// Below is n-1.
			n = (n - 1) / 26;
		}
		return buffer.reverse().toString();
	}

}
