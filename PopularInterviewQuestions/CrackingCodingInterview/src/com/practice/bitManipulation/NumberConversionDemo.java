package com.practice.bitManipulation;

public class NumberConversionDemo {
	public static void main(String[] args) {
		int n = 29;
		int m = 15;
		countChanges(n, m);
	}

	/// if c & (c-1) == 0, then it is a power of 2^n
	private static int countChanges(int n, int m) {
		int count = 0;
		for (int i = n ^ m; i != 0; i = i & (i - 1)) {
			count += 1;
			System.out.println(count);
		}
		return count;
	}
}
