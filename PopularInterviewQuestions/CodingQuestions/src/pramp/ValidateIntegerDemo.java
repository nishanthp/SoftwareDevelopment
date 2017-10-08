package newSet;

public class ValidateIntegerDemo {
	public static void main(String[] args) {
		String input1 = "37567c";
		String input2 = "375677";

		ValidateIntegerDemo d = new ValidateIntegerDemo();
		int n1 = d.parseInt(input1);
		int n2 = d.parseInt(input2);
		// Integer n11 = Integer.parseInt(input1);
		// int n2 = Integer.parseInt(input2);

		System.out.println(n1);
		System.out.println(n2);
	}

	public int parseInt(String input) throws NumberFormatException {
		int i = 0;
		int result = 0;
		while (i < input.length()) {
			int digit = Character.digit(input.charAt(i), 10);
			if (digit < 0) {
				throw new NumberFormatException("NAN");
			}
			result = result * 10;
			result += digit;
			i++;
		}

		return result;

	}
}
