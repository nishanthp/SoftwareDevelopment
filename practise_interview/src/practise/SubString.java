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

    void permutation(final String s) {

        allpermutations(" ", s);
    }

    /**
     * TODO Administrator (May 28, 2016) - Insert a description of what this method does.
     *
     * @param s
     * @param charAt
     * @param substring
     */
    private void allpermutations(final String prefix,
                                 final String substring) {
        final int n = substring.length();
        if (n == 0) {
            System.out.println(prefix);
        }
        for (int i = 0; i < n; i++) {
            allpermutations(prefix + substring.charAt(i), substring.substring(0, i) + substring.substring(i + 1, n));
        }
    }

    String addDigit(String str,
                    final char eachDigit,
                    final int digitIndex,
                    Integer carry) {
        Integer digit = Integer.parseInt(Character.toString(eachDigit));
        if (digitIndex == 0) {
            if (carry == 1) {
                digit = 0;
                str =
                        carry.toString() + str.substring(0, digitIndex) + digit.toString()
                                + str.substring(digitIndex + 1, str.length());
            }
            return str;
        }

        if (digit < 9) {
            digit = digit + 1;
            str = str.substring(0, digitIndex) + digit.toString() + str.substring(digitIndex + 1, str.length());
        } else {
            digit = 0;
            carry = 1;
            str = str.substring(0, digitIndex) + digit.toString() + str.substring(digitIndex + 1, str.length());
        }
        return addDigit(str, str.charAt(digitIndex - 1), digitIndex - 1, carry);
    }

    public int maxSubArray(final int a[]) {
        int maxSum = 0;
        final int sum[] = new int[a.length];
        sum[0] = a[0];
        for (int i = 1; i < a.length; i++) {
            sum[i] = Math.max(a[i], a[i] + sum[i - 1]);
            maxSum = Math.max(sum[i], maxSum);
        }
        return maxSum;
    }

    public int non_con_maxSubArray(final int a[]) {
        int maxSum = 0;
        int sum1;
        sum1 = a[0];
        for (int i = 1; i < a.length; i++) {
            sum1 = Math.max(a[i], a[i] + sum1);
            maxSum = Math.max(sum1, maxSum);
        }
        return maxSum;
    }


    int longestCommonPalindrome(final char str[],
                                final int start,
                                final int length) {
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


    int lcs(final char str1[],
            final char str2[]) {
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


    char[] doNotReverseSC(final String input) {

        char temp[] = new char[input.length()];
        temp = Arrays.copyOf(input.toCharArray(), input.length());
        for (int i = 0, j = temp.length - 1; i < temp.length; i++, j--) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                continue;
            }
            temp[j] = input.charAt(i);
        }
        return temp;
    }

    int threeSubSet(final int a[],
                    final int sum) {
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
