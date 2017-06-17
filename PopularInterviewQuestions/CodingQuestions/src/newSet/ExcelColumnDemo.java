package newSet;

import java.util.ArrayList;
import java.util.Stack;

public class ExcelColumnDemo {
	public static void main(String[] args) {
		int number = 705;
		ExcelColumnDemo d = new ExcelColumnDemo();
		String name = d.findColmnName(number);
		System.out.println(name);
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
