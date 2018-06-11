package Arrays;

public class Sort0s1s2s {
	public static void main(String[] args) {
		int input[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		Sort0s1s2s sort = new Sort0s1s2s();
		sort.sortArray(input);

		// print
		for (int digit : input) {
			System.out.println(digit);
		}
	}

	public void sortArray(int[] input) {
		int high = input.length - 1;
		int low = 0;
		int mid = 0;
		for (int i = 0; i < input.length; i++) {
			switch (input[mid]) {
			case 0:
				int temp = input[low];
				input[low] = input[mid];
				input[mid] = temp;
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp = input[high];
				input[high] = input[mid];
				input[mid] = temp;
				high--;
				break;
			}
		}
	}
}
