/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

/**
 * TODO Administrator (May 29, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class SolutionChanges {
	public static void main(String[] args) {
		int[] deno = { 1, 2, 3 };
		System.out.println(numberofSolutions(deno, 5));
		
	}

	public static int numberofSolutions(final int deno[], final int total) {
		final int temp[] = new int[total + 1];
		temp[0] = 1;
		for (final int element : deno) {
			for (int j = 1; j <= total; j++) {
				if (j >= element) {
					temp[j] += temp[j - element];
				}
			}
		}
		return temp[total];
	}
}
