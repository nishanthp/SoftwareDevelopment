package glassDoor;

import java.util.ArrayList;
import java.util.List;

public class NestedListIntegerDemo {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("{1,1}");
		list.add("2");
		list.add("{1,1}");
		int result = calculateSum(list, 1, 0);
		System.out.println(result);
	}

	private static int calculateSum(List<String> list, int depth, int index) {
		if (index >= list.size()) {
			return 0;
		}
		int sum = 0;
		for (int i = 0; i < list.get(index).length(); i++) {
			Character presentChar = list.get(index).charAt(i);
			int asciiValue = (int) presentChar;
			if (presentChar == '{') {
				depth++;
			} else if (presentChar == '}') {
				depth--;

			} else if (asciiValue >= 48 && asciiValue <= 57) {
				sum += depth * Integer.parseInt(presentChar.toString());
			}
		}

		if (depth != 1) {
			return -1;
		}
		return sum + calculateSum(list, depth, index + 1);

	}
}
