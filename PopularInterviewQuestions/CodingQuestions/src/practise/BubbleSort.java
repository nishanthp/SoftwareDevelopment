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
			swap = Boolean.FALSE;
			for (int j = 0; j < input.length - 1; j++) {
				if (input[j + 1] < input[j]) {
					swap(j + 1, j);
					swap = Boolean.TRUE;
				} 
			}
		}
	}

	private void swap(int index1, int index2) {
		int temp = input[index1];
		input[index1] = input[index2];
		input[index2] = temp;
	}
}
