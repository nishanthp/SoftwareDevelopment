package newSet;

public class PancakeSortDemo {
	public static void main(String[] args) {
		int[] input = { 1, 5, 4, 3, 2 };
		PancakeSortDemo d = new PancakeSortDemo();
		// d.pancakeSort(input);
		for (int result : d.pancakeSort(input)) {
			System.out.println(result);
		}
	}

	public int[] pancakeSort(int[] input) {
		for (int i = input.length - 1; i >= 0; i--) {
			int maxIndex = maxIndex(input, i);
			input = flip(input, maxIndex);
			input = flip(input, i);
		}
		return input;
	}

	public int maxIndex(int[] arr, int k) {
		int index = k;
		for (int i = 0; i <= k; i++) {
			if (arr[i] > arr[index]) {
				index = i;
			}
		}
		return index;
	}

	public int[] flip(int[] input, int k) {
		int rightIndex = k;
		int leftindex = 0;
		while (rightIndex > leftindex) {
			int temp = input[leftindex];
			input[leftindex] = input[rightIndex];
			input[rightIndex] = temp;
			leftindex++;
			rightIndex--;
		}
		return input;
	}
}
