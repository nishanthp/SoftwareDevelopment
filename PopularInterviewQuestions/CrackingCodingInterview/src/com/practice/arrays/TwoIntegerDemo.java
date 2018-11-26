package com.practice.arrays;

public class TwoIntegerDemo {
	public static void main(String[] args) {
		int i = 123;
		int j = 341;
		System.out.println(findCommonDigits(i, j));
	}

	private static int findCommonDigits(int i, int j) {
		byte[] bite = new byte[10];
		int count = 0;
		while (i != 0) {
			bite[i % 10]++;
			i = i / 10;
		}

		while (j != 0) {
			if (bite[j % 10] > 0) {
				count++;
			}
			j = j / 10;
		}
		return count;
	}
}
