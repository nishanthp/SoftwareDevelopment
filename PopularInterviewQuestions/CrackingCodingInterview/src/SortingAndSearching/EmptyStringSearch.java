package SortingAndSearching;

public class EmptyStringSearch {
	public static void main(String[] args) {
		String[] strings = new String[10];
		String input = "";
		searchString(strings, 0, strings.length, input);
	}

	private static int searchString(String[] strings, int first, int last, String input) {
		int mid = (first + last) / 2;
		if (strings[mid] == null) {
			int low = mid - 1;
			int high = mid + 1;
			while (true) {
				if (low > first && strings[low] != null) {
					mid = low;
					break;
				} else if (high > last && strings[high] != null) {
					mid = high;
					break;
				}

			}
		}

		if (strings[mid] == input) {
			return mid;
		} else if (strings[mid].compareTo(input) < 0) {
			return searchString(strings, first, last, input);
		} else {
			return searchString(strings, first, last, input);
		}
	}
}
