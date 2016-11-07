/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

/**
 * TODO Administrator (May 27, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class BubbleSort {
	Boolean swap;
	static int input[] = { 7, 6, 5, 4, 3, 2, 1 };

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.sort(input);

		// print.
		for (Integer i : input) {
			System.out.println(i);
		}
	}

	public void sort(int[] input) {
		swap = Boolean.TRUE;
		while (swap) {
			for (int i = 0; i < input.length; i++) {
				for (int j = i + 1; j < input.length; j++) {
					if (input[i] > input[j]) {
						swap(i, j);
						swap = Boolean.TRUE;
					}
				}
			}
			swap = Boolean.FALSE;
		}
	}

	private void swap(int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
}
