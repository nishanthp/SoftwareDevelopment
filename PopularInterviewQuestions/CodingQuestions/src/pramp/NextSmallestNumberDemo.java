package newSet;

public class NextSmallestNumberDemo {
	public static void main(String[] args) {
		int[] arr = { 100 };
		int[] arr1 = { 0, 1, 4, 2 };
		int[] arr2 = { 0, 1, 2, 3 };
		int[] arr3 = { 0, 1, 41, 21 };
		System.out.println(NextSmallestNumber(arr3));
	}

	private static int NextSmallestNumber(int[] arr) {
		int sortedIndex = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i) {
				sortedIndex = i;
				continue;
			}
			if (arr[i] > (arr.length - 1)) {
				if (i == (arr.length - 1))
					return sortedIndex + 1;
				else {
					sortedIndex = i - 1;
					continue;
				}
			} else {
				// swap
				int j = arr[i];
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				if ((sortedIndex + 1) == j) {
					sortedIndex = j;
				}
			}
		}

		return sortedIndex == -1 ? arr[arr.length - 1] + 1 : sortedIndex + 1;
	}
}
