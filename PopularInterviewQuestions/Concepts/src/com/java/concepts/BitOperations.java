package com.java.concepts;

public class BitOperations {

	public static void main(String[] args) {
		int n = 8;
		int m = 7;
		int r = n & m;
		// This is used to find whether a number is a power of 2, iff number >
		// 0.
		int powerOf2 = n & (n - 1);

		System.out.println(r);
		System.out.println(powerOf2);

		int result = Integer.parseInt("101110", 2);
		System.out.println(result);

		String intString = Integer.toBinaryString(result);
		System.out.println(intString);

	}

}
