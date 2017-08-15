package GlassDoor;

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
			char presentChar = list.get(index).charAt(i);
			if (presentChar == '{') {
				depth++;
			} else if (presentChar == '}') {
				depth--;
				
			}
			else if (48 >= presentChar && presentChar <= 57) {
				sum += depth * presentChar;
			}
		}

		if (depth != 1) {
			return -1;
		}
		return sum + calculateSum(list, depth, index + 1);

	}
}
