package arrays;

public class OverLappingArrayDemo {
	public static void main(String[] args) {
		String first = "abcd";
		String second = "bcde";

		String result = findOverlap(first, second);
		System.out.println(result);

	}

	public static String findOverlap(String first, String second) {
		char[] fir = first.toCharArray();
		char[] sec = second.toCharArray();
		if (!first.contains("" + sec[0])) {
			return first + second;
		}
		int index = 0;
		while (!matches(fir, sec, index)) {
			index++;
		}

		return first.substring(0, index) + second;

	}

	private static boolean matches(char[] fir, char[] sec, int index) {
		for (int i = index; i <= fir.length; i++) {
			if (fir[i] != sec[i - index]) {
				return false;
			} else
				return true;
		}
		return false;

	}
}
