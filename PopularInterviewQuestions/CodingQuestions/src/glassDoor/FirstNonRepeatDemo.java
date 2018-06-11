package GlassDoor;

public class FirstNonRepeatDemo {
	public static void main(String[] args) {
		int[] data = new int[256];
		String s = "abcdd";
		System.out.println(firstNonRepeat(s, data));
	}

	private static char firstNonRepeat(String s, int[] data) {
		char firstChar = ' ';
		if (s.isEmpty()) {
			return firstChar;
		}

		for (int i = 0; i < s.length(); i++) {
			data[s.charAt(i)] += 1;
		}

		for (int i = 0; i < s.length(); i++) {
			if (data[s.charAt(i)] > 1) {
				firstChar = s.charAt(i);
				break;
			}
		}
		return firstChar;
	}

}
