package arrays;

public class PalindromePermDemo {
	public static void main(String[] args) {
		String input = "tactcoa";

		System.out.println(permutationOfPalindrome(input));
	}

	// @method1
	private static boolean permutationOfPalindrome(String input) {
		int oddCount = 0;
		int[] table = new int[128];
		for (char c : input.toCharArray()) {
			int x = (int) c;
			table[x] += 1;
			if (table[x] % 2 == 1) {
				oddCount++;
			} else
				oddCount--;

		}

		return oddCount <= 1;
	}
}
