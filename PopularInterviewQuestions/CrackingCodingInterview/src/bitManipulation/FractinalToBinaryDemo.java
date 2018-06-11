package bitManipulation;

public class FractinalToBinaryDemo {
	public static void main(String[] args) {
		double num = 0.1;
		System.out.println(convertDecimalToDouble(num));
		System.out.println(convertDecimalToDoubleAlternate(num));
	}

	private static String convertDecimalToDouble(double num) {
		StringBuffer b = new StringBuffer();
		b.append(".");
		if (num > 1 || num < 0) {
			System.out.println("Does not fall in the range");
		}
		while (num > 0) {
			if (b.length() >= 32) {
				return b.toString();
			}
			double r = num * 2;
			if (r > 1) {
				b.append(1);
				num = r - 1;
			} else {
				b.append(0);
				num = r;
			}
		}
		return b.toString();

	}

	private static String convertDecimalToDoubleAlternate(double num) {
		StringBuffer b = new StringBuffer();
		double fraction = 0.5;
		b.append(".");
		if (num > 1 || num < 0) {
			System.out.println("Does not fall in the range");
		}
		while (num > 0) {
			if (b.length() >= 32) {
				return b.toString();
			}

			if (num >= fraction) {
				b.append(1);
				num -= fraction;
			} else {
				b.append(0);
			}
			fraction /= 2;
		}
		return b.toString();

	}
}
