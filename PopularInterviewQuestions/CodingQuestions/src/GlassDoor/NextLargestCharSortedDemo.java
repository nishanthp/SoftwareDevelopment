package GlassDoor;

public class NextLargestCharSortedDemo {
	public static void main(String[] args) {
		char[] input = { 'c', 'f', 'g', 'h', 'k' };

		System.out.println(nextLargest(input));
	}

	private static char nextLargest(char[] input) {
		char c = input[input.length - 1];
		return (char) (c + 1);

	}
}
