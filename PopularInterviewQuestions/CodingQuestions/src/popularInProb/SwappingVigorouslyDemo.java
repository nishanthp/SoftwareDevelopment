package popularInProb;

import java.util.Arrays;

import javax.swing.text.AbstractDocument.LeafElement;

public class SwappingVigorouslyDemo {
	public static void main(String[] args) {
		// 1st
		int input[] = { 1, 1, 0, 0, 0, 1, 0, 1 };
		for (int i : oneSwap(input)) {
			System.out.println(i);
		}
		// 2nd
		String binaryVal = Integer.toBinaryString(1234);
		int[] integerArray = convert(binaryVal.toCharArray());
		String result = Arrays.toString(oneSwap(integerArray));
		String res = result.replaceAll("\\D", "");
		int num = Integer.parseInt(res, 2);
		System.out.println(num);
		// 3rd
		int[] input2 = { 2, 3, 4, 1 };
		for (int i : oneSwapDigits(input2)) {
			System.out.println(i);
		}

		// 4th
		int input3 = 2341;
		String temp = Integer.toString(2341);
		System.out.println(temp);
		int[] input4 = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			input4[i] = temp.charAt(i) - '0';
		}
		for(int i:oneSwapDigits(input4))
		{
			System.out.println(i);
		}
	}

	private static int[] oneSwapDigits(int[] input2) {
		int leftIndex = 0;
		int maxValue = -1;
		int indexofMax = 0;
		for (int i = 1; i < input2.length; i++) {
			if (maxValue < input2[i]) {
				indexofMax = i;
				maxValue = input2[i];
			}

		}
		if (indexofMax == 0) {
			System.out.println("Cannot increase the number any more.");
			return input2;
		}

		return swap(input2, leftIndex, indexofMax);

	}

	private static int[] convert(char[] charArray) {
		int[] input1 = new int[charArray.length];
		int i = 0;
		for (char each : charArray) {
			if (each == '0') {
				input1[i] = 0;
			} else {
				input1[i] = 1;
			}
			i++;
		}
		return input1;
	}

	private static int[] oneSwap(int[] input) {
		int left = 0;
		int right = input.length - 1;
		while (left < right) {
			if (input[left] != 0) {
				left++;
			} else
				break;
		}

		while (left < right) {
			if (input[right] != 1) {
				right--;
			} else
				break;
		}

		if (left >= right) {
			System.out.println("The number cannot be made larger than what it is.");
		}

		return swap(input, left, right);

	}

	private static int[] swap(int[] input, int left, int right) {
		int temp = input[left];
		input[left] = input[right];
		input[right] = temp;
		return input;
	}
}
