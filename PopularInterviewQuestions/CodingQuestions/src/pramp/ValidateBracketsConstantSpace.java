package pramp;

public class ValidateBracketsConstantSpace {
	public static void main(String[] args) {
		String input = "(()())";
		System.out.println(validate(input));
	}

	private static boolean validate(String input) {
		int negativeCount = 0;
		int totalCount = 0;
		if (input.length() == 0) {
			return true;
		}

		for (char c : input.toCharArray()) {
			if (c == ')') {
				totalCount -= 1;
				if (totalCount < 0) {
					negativeCount += 1;
					totalCount = 0;
				}
			} else if (c == '(') {
				totalCount += 1;
			}
		}
		return (totalCount + negativeCount) == 0 ? true : false;
	}
}