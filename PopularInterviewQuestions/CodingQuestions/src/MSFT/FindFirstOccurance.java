package MSFT;

public class FindFirstOccurance {
	public static void main(String[] args) {
		int[] input = { 1, 1, 1, 1, 4, 4, 4, 6, 6, 6, 6, 8, 8 };
		int number = 8;
		int index = binarySearch(input, number, 0, input.length - 1);
		int firstIndex = -1;
		if (index != -1) {
			for (int i = index; i >= 0; i--) {
				if (input[i] == number) {
					firstIndex = i;
				} else
					break;
			}
		}

		System.out.println(firstIndex);
	}

	private static int binarySearch(int[] input, int number, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (input[mid] == number) {
			return mid;
		}

		if (input[mid] > number) {
			return binarySearch(input, number, low, mid - 1);
		} else {
			return binarySearch(input, number, mid + 1, high);
		}
	}
}
