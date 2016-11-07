/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

/**
 * TODO Administrator (Jun 5, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class SelectionSort {
	static int input[] = { 7, 6, 5, 4, 3, 2, 1 };

	public static void main(String[] args) {
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.sort(input);

		// print.
		for (int i : input) {
			System.out.println(i);
		}
	}

	public int[] sort(int input[]) {
		int index;
		for (int i = 0; i < input.length; i++) {
			index = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < input[index]) {
					index = j;
				}
			}
			if (i != index) {
				final int temp = input[i];
				input[i] = input[index];
				input[index] = temp;
			}
		}
		return input;

	}
}
