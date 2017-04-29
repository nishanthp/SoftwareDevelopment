package practise;

import javax.sound.sampled.AudioFormat.Encoding;

public class SquareStringDemo {
	static int lengthOfSquareString = 1;
	static int max = 0;

	public static void main(String[] args) {
		String input = "ababa";
		SquareStringDemo demo = new SquareStringDemo();

		for (int i = 0; i < input.length(); i++) {
			int temp = i;
			int length = 1;
			while (temp < input.length()) {
				demo.squareString(input, i, length);
				length = length + 1;
				temp = temp + 1;
			}
		}
		System.out.println(lengthOfSquareString);
	}

	public int squareString(String input, int startIndex, int length) {
		if (length <= input.length() / 2) {
			int endIndex = startIndex + length;
			String temp = input.substring(startIndex, endIndex);
			for (int j = startIndex + length; j <= startIndex + length; j++) {
				if (j + length > input.length()) {
					return lengthOfSquareString;
				}
				String t = input.substring(j, j + length);
				if (temp.equals(t))
					max = t.length() * 2;
				lengthOfSquareString = Math.max(max, lengthOfSquareString);
			}
		}
		return lengthOfSquareString;
	}
}
