package com.accpeted.submissions;

public class AddBinary {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public String addBinary(String a, String b) {
		int i = a.length() - 1;
		int j = b.length() - 1;
		int currSum = 0;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 || j >= 0) {
			currSum = carry;
			if (i >= 0)
				currSum += a.charAt(i) - '0';
			if (j >= 0)
				currSum += b.charAt(j) - '0';
			if (currSum >= 2)
				carry = 1;
			else
				carry = 0; // important part.
			sb.append(currSum % 2);
			i--;
			j--;
		}
		if (carry > 0)
			sb.append(carry);
		return sb.reverse().toString();
	}

}
