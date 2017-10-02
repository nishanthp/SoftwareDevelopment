package newSet;

import java.util.ArrayList;
import java.util.Stack;

public class ExcelColumnDemo {
	public static void main(String[] args) {
		int number = 705;
		ExcelColumnDemo d = new ExcelColumnDemo();
		/*
		 * String name = d.findColmnName(number); System.out.println(name);
		 */
		System.out.println(d.columnNumber("AAC"));
		System.out.println(d.columnName(705));

	}

	// much simpler method.
	private String columnName(int colmnNumber) {

		StringBuilder name = new StringBuilder();
		while (colmnNumber > 0) {
			// because we added a 1.
			colmnNumber--;
			name.append((char) (colmnNumber % 26 + 'A'));
			colmnNumber /= 26;
			System.out.println(colmnNumber);
		}
		return name.reverse().toString();
	}

	// much simpler method.
	private int columnNumber(String colmnName) {
		int i = colmnName.length() - 1;
		int t = 0;
		int result = 0;
		while (i >= 0) {
			result += Math.pow(26, t) * (colmnName.charAt(i) - 'A' + 1);
			i--;
			t++;
		}
		return result;
	}

	private String findColmnName(int number) {
		Stack<Character> charArray = new Stack<>();
		String previous = null;
		if (number > 26) {
			int remainder = number % 26;
			charArray.add(convertNumberToAscii(remainder));
			int quo = number / 26;
			if (quo > 26) {
				previous = findColmnName(quo);
			} else {
				charArray.add(convertNumberToAscii(quo));
			}
		} else {
			charArray.add(convertNumberToAscii(number));
		}
		return convertCharArrayToString(previous, charArray);

	}

	private String convertCharArrayToString(String previous, Stack<Character> charStack) {
		StringBuffer buffer = new StringBuffer();
		while (!charStack.isEmpty()) {
			buffer.append(charStack.pop());
		}
		if (previous != null)
			return previous + buffer.toString();
		else
			return buffer.toString();
	}

	private char convertNumberToAscii(int remainder) {
		int BASE = 65;
		return (char) (BASE + remainder - 1);
	}

}
