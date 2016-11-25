/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

/**
 * TODO Administrator (Jun 5, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class QuickSelect {
	public static void main(String[] args) {
		int[] input = { 7, 6, 5, 4, 3, 2, 1 };
		QuickSelect select = new QuickSelect();
		System.out.println(select.kthLargestElement(2, input));
	}

	public int kthLargestElement(final int k, final int a[]) {
		return getkthLargestElement(a, 0, a.length - 1, a.length - k);
	}

	private int getkthLargestElement(final int[] a, final int start, final int end, final int k) {
		int left = start;
		int right = end;
		final int pivot = a[end];
		while (true) {
			while (a[left] < pivot && left < end) {
				left++;
			}
			while (a[right] > pivot && right > start) {
				right--;
			}

			if (left == right) {
				break;
			}
			swap(a, left, right);

		}
		// swap(a, left, end);
		if (k == left) {
			return pivot;
		} else if (k < left) {
			return getkthLargestElement(a, start, left - 1, k);
		} else {
			return getkthLargestElement(a, left + 1, end, k);
		}
	}

	/**
	 * TODO Administrator (Jun 5, 2016) - Insert a description of what this
	 * method does.
	 *
	 * @param a
	 * @param left
	 * @param right
	 */
	private void swap(final int[] a, final int left, final int right) {
		final int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

}
