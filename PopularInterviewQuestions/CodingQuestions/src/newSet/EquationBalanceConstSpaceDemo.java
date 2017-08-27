package newSet;

public class EquationBalanceConstSpaceDemo {
	public static void main(String[] args) {
		String input = "((()))()";
		System.out.println(bracketMatch(input));
	}

	private static int bracketMatch(String input) {
		int imbalance = 0;
		int result = 0;
		if (input == null) {
			return imbalance;
		}
		for (char eachChar : input.toCharArray()) {
			if (eachChar == '(') {
				imbalance += 1;
			} else if (eachChar == ')') {
				imbalance -= 1;
			}
			if (imbalance < 0) {
				imbalance += 1;
				result += 1;
			}
		}
		return result + imbalance;
	}
}
