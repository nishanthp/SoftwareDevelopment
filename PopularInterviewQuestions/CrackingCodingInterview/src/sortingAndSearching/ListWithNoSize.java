package SortingAndSearching;

import java.util.*;

public class ListWithNoSize {
	public static void main(String[] args) {
		// assume this does not have size as a method.
		List<Integer> list = new ArrayList<Integer>();
		int value = 0;
		int high = findValue(list, value);
		binarySearch(list, value, (high / 2), high);
	}

	private static int binarySearch(List<Integer> list, int value, int low, int high) {
		while (high < low) {
			int mid = (low + high) / 2;
			if (mid == value) {
				return mid;
			} else if (mid > value) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	private static int findValue(List<Integer> list, int value) {
		int index = 0;
		while (list.get(index) != -1 && list.get(index) < value) {
			index *= 2;
		}
		return index;
	}
}
