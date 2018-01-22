package pramp;

import java.util.Arrays;

public class MinValueProductDemo {
	public static void main(String[] args) {
		int arr[] = { 4, 2, 1, 10, 6 };
		System.out.println(findxProduct(arr));
	}

	private static int findxProduct(int[] arr) {
		double val = 0;
		int result = Integer.MIN_VALUE;
		Arrays.sort(arr);
		// find product.
		for (int i = 0; i < arr.length; i++) {
			val += Math.log(arr[i]);
		}

		// binary search
		int left = 0;
		int right = arr.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (Math.log(Math.pow(arr[mid], arr.length)) > val) {
				result = arr[mid];
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
}
