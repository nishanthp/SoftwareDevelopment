package com.practice.arrays;

public class PeakValleyDemo {
	public static void main(String[] args) {
		int[] arr = { 5, 3, 1, 2, 3 };
		int[] result = peakValley(arr);
		for (int each : result) {
			System.out.println(each);
		}
	}

	private static int[] peakValley(int[] arr) {
		if (arr.length <= 2) {
			return null;
		}
		for (int i = 1; i < arr.length; i += 2) {
			int biggestIndex = biggestIndex(arr, i - 1, i, i + 1);
			if (biggestIndex != i) {
				arr = swap(arr, i, biggestIndex);
			}
		}
		return arr;
	}

	private static int[] swap(int[] arr, int i, int biggestIndex) {
		int temp = arr[biggestIndex];
		arr[biggestIndex] = arr[i];
		arr[i] = temp;
		return arr;
	}

	private static int biggestIndex(int[] arr, int a, int b, int c) {
		int length = arr.length - 1;
		int aValue = a >= 0 && a <= length ? arr[a] : Integer.MIN_VALUE;
		int bValue = b >= 0 && b <= length ? arr[b] : Integer.MIN_VALUE;
		int cValue = c >= 0 && c <= length ? arr[c] : Integer.MIN_VALUE;

		int max = Math.max(aValue, Math.max(bValue, cValue));
		if (aValue == max)
			return a;
		else if (bValue == max)
			return b;
		else
			return c;
	}
}
