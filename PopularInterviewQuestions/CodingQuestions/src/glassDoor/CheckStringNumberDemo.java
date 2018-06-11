package glassDoor;

public class CheckStringNumberDemo {
	public static void main(String[] args) {
		String input = "122345669";
		String input2 = "1245ab3";
		String input3 = "124}7";
		System.out.println(checkIfNumeric(input3));
	}

	private static boolean checkIfNumeric(String input) {
		for (char c : input.toCharArray()) {
			if (48 < c && c > 57) {
				return false;
			}
		}
		return true;

	}
}
