package newSet;

import java.util.Arrays;

public class PairValueWithSubDemo {
	// Pair with a subtraction.
	public static void main(String[] args) {
		// In constant space.
		int[] input = { 0, -1, -2, 2, 1 };
		int k = 1;
		for (int[] eachRow : findSubtractionPair(input, k)) {
			if (eachRow != null) {
				System.out.println(eachRow[0] + " " + eachRow[1]);
			}
		}
	}

	// Time complexity - O(n+nlogn), Space complexity - O(1). Can be done using
	// Hashmap, then space complexity will not be constant, but time complexity
	// increases.
	private static int[][] findSubtractionPair(int[] input, int k) {
		int left = 0;
		int right = 1;
		int[][] result = new int[input.length][];
		int i = 0;
		Arrays.sort(input);
		while (left >= 0 && right < input.length && left < right) {
			// find pairs.
			int diff = input[right] - input[left];
			if (diff == k) {
				result[i++] = new int[] { input[left], input[right] };
				left++;
				right++;
			} else if (diff > k) {
				left++;
			} else {
				right++;
			}
		}
		return result;
	}
}
