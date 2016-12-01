/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

import java.util.Arrays;

/**
 * TODO Administrator (May 28, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class SubString {
	int i = 0;

	public static void main(String[] args) {
		final String a = "89";
		final String res = addDigit(a, a.charAt(a.length() - 1), a.length() - 1, 0);
		System.out.println(res);

		final int input[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		// int sum = non_con_maxSubArray(input);
		int sum = maxSubArray(input);
		System.out.println(sum);

		final int input2[] = { -2, 0, 1, 3 };
		// System.out.println(threeSubSet(input2, 2));
		System.out.println(doNotReverseSC("a,bc$"));

		final String str = "agbdba";
		// System.out.println(longestCommonPalindrome(str.toCharArray(), 0, 6));
		final String s1 = "abcdaf";
		final String s2 = "acbcf";
		System.out.println(lcs(s1.toCharArray(), s2.toCharArray()));

	}

	public void permutation(final String s) {

		allpermutations(" ", s);
	}

	/**
	 * TODO Administrator (May 28, 2016) - Insert a description of what this
	 * method does.
	 *
	 * @param s
	 * @param charAt
	 * @param substring
	 */
	private void allpermutations(final String prefix, final String substring) {
		final int n = substring.length();
		if (n == 0) {
			System.out.println(prefix);
		}
		for (int i = 0; i < n; i++) {
			allpermutations(prefix + substring.charAt(i), substring.substring(0, i) + substring.substring(i + 1, n));
		}
	}

	public static String addDigit(String str, final char eachD, final int eachDIndex, Integer carry) {
		Integer digit = Integer.parseInt(Character.toString(eachD));
		if (eachDIndex == 0) {
			if (carry == 1 && digit == 9) {
				digit = 0;
				return str = carry.toString() + digit.toString() + str.substring(eachDIndex + 1);
			} else if (carry == 1 && digit < 9) {
				digit = digit + carry;
				return str = digit.toString() + str.substring(eachDIndex + 1);
			} else {
				return str;
			}
		}

		if (digit < 9) {
			digit = digit + 1;
		} else {
			digit = 0;
			carry = 1;
		}
		str = str.substring(0, eachDIndex) + digit.toString() + str.substring(eachDIndex + 1, str.length());
		return addDigit(str, str.charAt(eachDIndex - 1), eachDIndex - 1, carry);
	}

	public static int maxSubArray(final int a[]) {
		int maxSum = 0;
		final int sum[] = new int[a.length];
		sum[0] = a[0];
		for (int i = 1; i < a.length; i++) {
			sum[i] = Math.max(a[i], a[i] + sum[i - 1]);
			maxSum = Math.max(sum[i], maxSum);
		}
		return maxSum;
	}

	public static int non_con_maxSubArray(final int a[]) {
		int maxSum = 0;
		int sum1;
		sum1 = a[0];
		for (int i = 1; i < a.length; i++) {
			sum1 = Math.max(a[i], a[i] + sum1);
			maxSum = Math.max(sum1, maxSum);
		}
		return maxSum;
	}

	public static int longestCommonPalindrome(final char str[], final int start, final int length) {
		// Stop when length becomes equal to 0.
		if (length == 0) {
			return 0;
		}

		if (length == 1) {
			return 1;
		}

		if (str[start] == str[start + length - 1]) {
			return 2 + longestCommonPalindrome(str, start + 1, length - 2);
		}
		return Math.max(longestCommonPalindrome(str, start, length - 1),
				longestCommonPalindrome(str, start + 1, length - 1));

	}

	public static int lcs(final char str1[], final char str2[]) {
		final int temp[][] = new int[str1.length + 1][str2.length + 1];
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[i].length; j++) {
				if (str1[i - 1] == str2[j - 1]) {
					temp[i][j] = 1 + temp[i - 1][j - 1];
				} else {
					temp[i][j] = Math.max(temp[i - 1][j], temp[i][j - 1]);
				}
			}

		}

		return temp[str1.length][str2.length];
	}

	public static char[] doNotReverseSC(final String input) {
		char temp[] = new char[input.length()];
		temp = Arrays.copyOf(input.toCharArray(), input.length());
		for (int i = 0, j = temp.length - 1; i < temp.length;) {
			if (!Character.isLetterOrDigit(temp[i])) {
				i++;
				continue;
			} else {
				while (j >= 0 && !Character.isLetterOrDigit(temp[j])) {
					j--;
				}
				// swap.
				char t = temp[j];
				temp[j] = temp[i];
				temp[i] = t;
				i++;
				j--;
				if (i >= j) {
					break;
				}
			}
		}

		return temp;
	}

	public static int threeSubSet(final int a[], final int sum) {
		int count = 0;
		for (int i = 0; i < a.length - 2; i++) {
			for (int j = i + 1; j < a.length - 1; j++) {
				for (int k = j + 1; k < a.length; k++) {
					if (a[i] + a[j] + a[k] < sum) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
