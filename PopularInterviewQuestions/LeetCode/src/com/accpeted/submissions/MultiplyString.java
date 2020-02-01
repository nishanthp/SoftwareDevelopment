package com.accpeted.submissions;

public class MultiplyString {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public String multiply(String num1, String num2) {
		if (num1 == "0" || num2 == "0")
			return "0";
		int[] result = new int[num1.length() + num2.length()];
		for (int i = num1.length() - 1; i >= 0; i--) {
			for (int j = num2.length() - 1; j >= 0; j--) {
				int d1 = num1.charAt(i) - '0';
				int d2 = num2.charAt(j) - '0';
				result[i + j + 1] += d1 * d2;
				// System.out.println(d1*d2);
			}
		}
		int carry = 0;
		for (int i = result.length - 1; i >= 0; i--) {
			int currSum = (result[i] + carry) % 10;
			carry = (result[i] + carry) / 10;
			System.out.println(currSum + " " + carry);
			result[i] = currSum;
		}
		int index = 0;
		while (index < result.length && result[index] == 0)
			index++;
		StringBuffer sb = new StringBuffer();
		for (int i = index; i < result.length; i++) {
			if (i == 0 && result[i] == 0)
				continue;
			sb.append(result[i]);
		}

		return sb.length() == 0 ? "0" : sb.toString();
	}

}
