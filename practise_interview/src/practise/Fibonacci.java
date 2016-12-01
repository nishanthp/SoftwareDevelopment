/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

/**
 * TODO Administrator (Jun 5, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class Fibonacci {
	public static void main(String[] args) {

		String temp = reverseStringRec("abc");
		System.out.println(temp);
	}

	int fibonacci(final int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);

	}

	public static String reverseStringRec(final String str) {
		if (str.length() < 2) {
			return str;
		}
		return reverseStringRec(str.substring(1)) + str.charAt(0);
	}

	boolean reversenumberPali(int n) {
		final int num = n;
		int reverse = 0;
		while (n != 0) {
			reverse = reverse * 10 + n % 10;
			n = n / 10;
		}
		if (num == reverse) {
			return true;
		}
		return false;
	}
}
