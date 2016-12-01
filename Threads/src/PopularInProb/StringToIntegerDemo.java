package PopularInProb;

public class StringToIntegerDemo {
	public static void main(String[] args) {
		String number = "1234";
		int result = 0;
		int factor = 1;
		for (int i = number.length() - 1; i >= 0; i--) {
			result += (number.charAt(i) - '0') * factor;
			factor = factor * 10;
		}

		// result = Integer.parseInt("1234");
		System.out.println(result);
	}
}
