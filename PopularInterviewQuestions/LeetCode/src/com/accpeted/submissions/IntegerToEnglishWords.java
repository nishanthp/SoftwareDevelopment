package com.accpeted.submissions;

public class IntegerToEnglishWords {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	private final String[] belowTen = new String[]{"", "One", "Two", "Three",
			"Four", "Five", "Six", "Seven", "Eight", "Nine"};
	private final String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen"};
	private final String[] belowHundred = new String[]{"", "Ten", "Twenty",
			"Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";
		return num < 0
				? "Negative " + numberToWordsT(Math.abs(num))
				: numberToWordsT(num);
	}
	private String numberToWordsT(int num) {
		StringBuffer sb = new StringBuffer();
		if (num < 10)
			sb.append(belowTen[num]);
		else if (num < 20)
			sb.append(belowTwenty[num % 10]);
		else if (num < 100)
			sb.append(belowHundred[num / 10]).append(" ")
					.append(numberToWordsT(num % 10));
		else if (num < 1000)
			sb.append(belowTen[num / 100]).append(" Hundred ")
					.append(numberToWordsT(num % 100));
		else if (num < 1000000)
			sb.append(numberToWordsT(num / 1000)).append(" Thousand ")
					.append(numberToWordsT(num % 1000));
		else if (num < 1000000000)
			sb.append(numberToWordsT(num / 1000000)).append(" Million ")
					.append(numberToWordsT(num % 1000000));
		else
			sb.append(numberToWordsT(num / 1000000000)).append(" Billion ")
					.append(numberToWordsT(num % 1000000000));
		return sb.toString().trim();
	}

}
