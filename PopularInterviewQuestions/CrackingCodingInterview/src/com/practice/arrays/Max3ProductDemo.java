package com.practice.arrays;

public class Max3ProductDemo {
	public static void main(String[] args) {
		int[] array = { 2, 1, 4, 3 };
		int result = maxProduct(array);
		System.out.println(result);
	}

	static int maxProduct(int[] array) {
		int max1 = Integer.MIN_VALUE;
		int max2 = Integer.MIN_VALUE;
		int max3 = Integer.MIN_VALUE;
		int min1 = Integer.MAX_VALUE;
		int min2 = Integer.MAX_VALUE;

		for (int each : array) {
			if (each > max1) {
				max3 = max2;
				max2 = max1;
				max1 = each;
			} else if (each > max2) {
				max3 = max2;
				max2 = each;
			} else {
				max3 = each;
			}

			if (each < min1) {
				min2 = min1;
				min1 = each;
			} else if (each < min2) {
				min2 = each;
			}
		}

		return Math.max(max1 * max2 * max3, min1 * min2 * max1);
	}
}
