package popularInProb;

import java.util.ArrayDeque;

public class ReverseStringWithoutDS {
	static String input = "this is paypal";
	static int leftIndex = 0;
	static int rightIndex = input.length() - 1;
	static String result;

	public static void main(String[] args) {
		result = reverseString(input, leftIndex, rightIndex);
		char[] resultant = result.toCharArray();
		for (int i = 0; i <= rightIndex; i++) {
			if (resultant[i] == ' ') {
				result = reverseString(result, leftIndex, i - 1);
				leftIndex = i + 1;

			} else if (i == rightIndex) {
				result = reverseString(result, leftIndex, rightIndex);
			}
		}
		System.out.println(result);

	}

	public static String reverseString(String input, int leftindex, int rightindex) {
		char[] inputArray = input.toCharArray();
		char temp;
		while (leftindex < rightindex) {
			temp = inputArray[leftindex];
			inputArray[leftindex] = inputArray[rightindex];
			inputArray[rightindex] = temp;
			leftindex++;
			rightindex--;
		}
		return new String(inputArray);
	}
}
