/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

/**
 * TODO Administrator (Jun 5, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class InsertionSort {

	static int[] input = { 7, 6, 5, 4, 3, 2, 1 };

	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.sort(input);

		// print.
		for (int i : input) {
			System.out.println(i);
		}
	}

	public void sort(final int input[]) {
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j] < input[j - 1]) {
					swap(j, j - 1);
				}
			}
		}
	}

	private void swap(int j, int i) {
		final int tmp = input[j];
		input[j] = input[j - 1];
		input[j - 1] = tmp;
	}
}
