package com.accpeted.submissions;

public class LongPressName {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean isLongPressedName(String name, String typed) {
		int index = 0;
		for (char each : name.toCharArray()) {
			if (index == typed.length())
				return false;
			if (each != typed.charAt(index)) {
				if (index == 0
						|| typed.charAt(index) != typed.charAt(index - 1))
					return false;
				char prevChar = typed.charAt(index);
				while (index < typed.length()
						&& typed.charAt(index) == prevChar)
					index++;
				if (index == typed.length() || typed.charAt(index) != each)
					return false;

			}
			index++;
		}
		return true;
	}

}
