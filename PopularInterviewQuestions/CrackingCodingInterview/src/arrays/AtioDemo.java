package arrays;

import org.omg.PortableInterceptor.INACTIVE;

// This is the demo.
public class AtioDemo {
	public static void main(String[] args) {
		int res = atio("+1234");
		System.out.println(res);
	}

	public static int atio(String str) {
		if (str == null || str.length() == 0) {
			return -1;
		}
		int i = 0;
		char sign = str.charAt(0);

		char flag = '+';

		if (sign == '-') {
			flag = '-';
			i++;
		} else {
			i++;
		}

		int result = 0;
		while (str.length() > i && '0' <= str.charAt(i) && str.charAt(i) <= '9') {
			int in = str.charAt(i) - '0';
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}

		if (flag == '-') {
			result = -result;
		}
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		return result;
	}
}
