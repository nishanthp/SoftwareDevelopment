package pramp;

public class DuplicateElementArraysDemo {
	static int outIndex = 0;

	public static void main(String[] args) {
		int[] array1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int[] array2 = { 3, 6, 8 };
		int loopIndex = Math.min(array1.length, array2.length);
		int maxArrayIndex = Math.max(array1.length, array2.length);
		for(int out :findDuplicates(array1, maxArrayIndex, array2, loopIndex)) {
			System.out.println(out);
		}
	}

	private static int[] findDuplicates(int[] array1, int maxArrayIndex, int[] array2, int loopIndex) {
		int[] output = new int[loopIndex];
		int j = 0;
		for (int i = 0; i < loopIndex; i++) {
			int left = 0;
			output = binarySearch(array1, array2[i], left, maxArrayIndex, output);
		}
		return output;

	}

	private static int[] binarySearch(int[] input, int element, int left, int right, int[] output) {
		int mid = (left + right) / 2;
		if (input[mid] == element) {
			output[outIndex++] = input[mid];
			return output;
		}
		while (left < right) {
			if (input[mid] > element) {
				return binarySearch(input, element, left, mid, output);
			} else if (input[mid] < element) {
				return binarySearch(input, element, mid + 1, right, output);
			}
		}
		return output;
	}
}
