package Revision;

public class ReverseStringInSpaceDemo {
	public static void main(String[] args) {
		char[] input = { 'p', 'e', 'r', 'f', 'e', 'c', 't', ' ', 'm', 'a', 'k', 'e', 's', ' ', 'p', 'r', 'a', 'c', 't',
				'i', 'c', 'e' };
		for (char each : reverseString(input)) {
			System.out.println(each);
		}
	}

	private static char[] reverseString(char[] input) {
		if (input.length == 0) {
			return input;
		}
		// reverse the entire array.
		reverse(input, 0, input.length - 1);
		// reverse each word in the string.
		int j = 0;
		for (int i = 0; i < input.length - 1;) {
			if (j >= input.length) {
				reverse(input, i, j - 1);
				break;
			} else if (input[j] == ' ') {
				reverse(input, i, j - 1);
				i = j + 1;
				j = i;
			} else {
				j++;
			}

		}
		return input;

	}

	private static char[] reverse(char[] input, int leftIndex, int rightIndex) {
		while (leftIndex < rightIndex) {
			char temp = input[leftIndex];
			input[leftIndex] = input[rightIndex];
			input[rightIndex] = temp;
			leftIndex++;
			rightIndex--;
		}
		return input;
	}

}
