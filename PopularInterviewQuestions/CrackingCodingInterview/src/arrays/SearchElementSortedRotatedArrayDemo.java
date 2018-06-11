package arrays;

public class SearchElementSortedRotatedArrayDemo {
	public static void main(String[] args) {
		int[] array1 = { 10, 15, 20, 0, 5 };
		System.out.println(findElement(array1, 0, array1.length - 1, 5));
	}

	public static int findElement(int[] input, int left, int right, int x) {
		int mid = (left + right) / 2;

		if (left > right) {
			return -1;
		}
		if (input[mid] == x) {
			return mid;
		}

		if (input[left] < input[mid]) {
			if (input[left] <= x && x <= input[mid]) {
				return findElement(input, left, mid - 1, x);
			} else {
				return findElement(input, mid + 1, right, x);
			}
		} else if (input[left] > input[mid]) {
			if (input[mid] >= x && x <= input[right]) {
				return findElement(input, mid + 1, right, x);
			} else {
				return findElement(input, left, mid - 1, x);
			}
		} else if (input[mid] == input[left]) {
			if (input[mid] != input[right]) {
				return findElement(input, mid + 1, right, x);
			} else {
				int result = findElement(input, left, mid - 1, x);
				if (result == -1) {
					return findElement(input, mid + 1, right, x);
				} else {
					return result;
				}
			}
		}

		return -1;

	}
}
