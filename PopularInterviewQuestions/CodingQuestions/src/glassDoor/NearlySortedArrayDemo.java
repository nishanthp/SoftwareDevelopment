package glassDoor;

import java.util.PriorityQueue;

public class NearlySortedArrayDemo {
	// Nearly sorted in the sense that the array is shift sorted by k.(either
	// left or right).
	public static void main(String[] args) {
		int[] input = { 1, 4, 5, 2, 3, 7, 8, 6, 10, 9 };
		int k = 2;
		for (int element : sortArray(input, k)) {
			System.out.println(element);
		}

	}

	private static int[] sortArray(int[] input, int k) {
		if (input.length == 0) {
			return new int[0];
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();

		// add the first k elements.
		for (int i = 0; i <= k; i++) {
			minHeap.add(input[i]);
		}

		int index = 0;
		int addIndex = k + 1;
		while (!minHeap.isEmpty()) {
			input[index++] = minHeap.poll();
			if ((index + k) < input.length) {
				minHeap.add(input[index + k]);
			}
		}
		return input;
	}
}