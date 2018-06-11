package glassDoor;

public class RomanToIntDemo {
	public static void main(String[] args) {
		String s = "MCMIV";
		int n = romanToInt(s);
		System.out.println(n);
	}

	private static int romanToInt(String s) {
		int decimalValue = 0;
		int currentValue = 0;
		int previousValue = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			char presentChar = s.charAt(i);

			switch (presentChar) {

			case 'I':
				currentValue = 1;
				decimalValue = processValue(decimalValue, currentValue, previousValue);
				previousValue = currentValue;
				break;
			case 'V':
				currentValue = 5;
				decimalValue = processValue(decimalValue, currentValue, previousValue);
				previousValue = currentValue;
				break;
			case 'X':
				currentValue = 10;
				decimalValue = processValue(decimalValue, currentValue, previousValue);
				previousValue = currentValue;
				break;
			case 'L':
				currentValue = 50;
				decimalValue = processValue(decimalValue, currentValue, previousValue);
				previousValue = currentValue;
				break;
			case 'C':
				currentValue = 100;
				decimalValue = processValue(decimalValue, currentValue, previousValue);
				previousValue = currentValue;
				break;
			case 'D':
				currentValue = 500;
				decimalValue = processValue(decimalValue, currentValue, previousValue);
				previousValue = currentValue;
				break;
			case 'M':
				currentValue = 1000;
				decimalValue = processValue(decimalValue, currentValue, previousValue);
				previousValue = currentValue;
				break;

			}
		}
		return decimalValue;
	}

	private static int processValue(int decimalValue, int currentValue, int previousValue) {
		if (currentValue > previousValue) {
			return decimalValue + currentValue;
		} else {
			return decimalValue - currentValue;
		}
	}
}
