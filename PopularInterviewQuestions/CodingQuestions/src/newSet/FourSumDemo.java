package newSet;

import java.util.Arrays;

public class FourSumDemo {
	public static void main(String[] args) {
		int[] input = { 2, 7, 4, 0, 9, 5, 1, 3 };
		int sum = 20;
		for (int each : findFourSum(input, sum)) {
			System.out.println(each);
		}

	}

	private static int[] findFourSum(int[] input, int sum) {
		// sort the array. this is O(nlogn).
		Arrays.sort(input);
		// array can be initialized to null.
		int[] result = null;
		for (int i = 0; i < input.length - 3; i++) {
			for (int j = i + 1; j < input.length - 2; j++) {
				int remainingSum = sum - (input[i] + input[j]);
				int leftIndex = j + 1;
				int rightIndex = input.length - 1;
				while (leftIndex < rightIndex) {
					if (input[leftIndex] + input[rightIndex] == remainingSum) {
						return result = new int[] { input[i], input[j], input[leftIndex], input[rightIndex] };
					} else if (input[leftIndex] + input[rightIndex] > remainingSum) {
						rightIndex -= 1;
					} else {
						leftIndex += 1;
					}
				}
			}
		}
		return result;
	}
}
