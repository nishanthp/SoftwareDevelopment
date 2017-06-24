package newSet;

import java.math.BigInteger;
import java.util.Arrays;

public class MinValueProductDemo {
	public static void main(String[] args) {
		int arr[] = { 4, 2, 1, 10, 6 };
		findxProduct(arr);
	}

	private static void findxProduct(int[] arr) {
		double val = 0;
		Arrays.sort(arr);
		// find product.
		for (int i = 0; i < arr.length; i++) {
			val += Math.log(arr[i]);
		}
	}
}
