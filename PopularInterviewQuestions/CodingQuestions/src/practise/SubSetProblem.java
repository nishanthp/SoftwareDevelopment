/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

/**
 * TODO Administrator (May 26, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class SubSetProblem {

	int actualSum = 9;
	int a[] = { 1, 2, 3, 4, 5 };
	int i = 0;
	int n = 0;

	private boolean doesExsist = false;

	public static void main(String[] args) {
		final SubSetProblem s = new SubSetProblem();
		final int a[] = { 1, 2, 3, 4, 5 };
		final int actualSum = 6;
		/*
		 * s.subSet(a, actualSum); s.nonConti(a, actualSum, a.length);
		 * s.nonConti1(a, actualSum, a.length);
		 */
		int input[] = { 1,1,2,2,3};
		int result = s.findNonDuplicateElement(input);
		System.out.println(result);
	}

	public boolean subSet(final int a[], final int actualSum) {
		if (this.i + 1 < a.length) {
			if (a[this.i] + a[this.i + 1] == actualSum) {
				this.doesExsist = true;
				return this.doesExsist;
			}
			this.i++;
			return subSet(a, actualSum);
		}
		return this.doesExsist;
	}

	public boolean nonConti(final int a[], final int actualSum, final int n) {
		if (actualSum == 0) {
			return true;
		}
		if (n == 0 && actualSum != 0) {
			return false;
		}
		if (a[n - 1] > actualSum)

		{
			return nonConti(a, actualSum, n - 1);
		}
		return nonConti(a, actualSum, n - 1) || nonConti(a, actualSum - a[n - 1], n - 1);
	}

	public boolean nonConti1(final int a[], final int actualSum, int n) {

		if (actualSum == 0) {
			return true;
		}

		for (final int element : a) {
			if (actualSum == element) {
				return true;
			}

		}

		return nonConti(a, actualSum - a[this.i], n++);
	}

	void palindrome(final String s) {
		String reverse = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			reverse += s.charAt(i);
		}
		if (reverse.equals(s)) {
			System.out.println("Palindrome");
		}
	}

	public int findNonDuplicateElement(int[] input) {
		int result = input[0];
		for (int i = 1; i < input.length; ++i) {
			result ^= input[i];
		}
		return result;
	}
}
