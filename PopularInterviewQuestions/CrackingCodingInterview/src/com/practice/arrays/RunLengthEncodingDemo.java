package com.practice.arrays;

public class RunLengthEncodingDemo {
	public static void main(String[] args) {
		String input = "aabcccccaaa";
		System.out.println(findCompressedString(input));
	}

	public static String findCompressedString(String input) {
		StringBuffer buffer = new StringBuffer();
		char last = input.charAt(0);
		int count = 1;
		for (int i = 1; i < input.length(); i++) {
			if (last == input.charAt(i)) {
				count++;
			} else {
				buffer.append(last);
				buffer.append(count);
				last = input.charAt(i);
				count = 1;
			}
		}
		buffer.append(last);
		buffer.append(count);
		return new String(buffer);
	}
}
