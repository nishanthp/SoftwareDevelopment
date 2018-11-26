package com.practice.stack;

public class FindMinNumberDemo {
	static StringBuffer buffer = new StringBuffer();

	public static void main(String[] args) {
		String i = "4325043";
		int n = 3;
		createLow(i, n);
		System.out.println(new String(buffer));

	}

	private static void createLow(String input, int n) {
		if (n == 0) {
			buffer.append(input);
			return;
		}
		int len = input.length();
		if (len < n) {
			return;
		}
		int minIndex = 0;
		for (int i = 1; i <= n; i++) {
			if (input.charAt(i) < input.charAt(minIndex)) {
				minIndex = i;
				System.out.println(input.charAt(minIndex));
			}
		}

		buffer.append(input.charAt(minIndex));

		String newStrin = input.substring(minIndex + 1, len);
		createLow(newStrin, n - minIndex);
	}

}
