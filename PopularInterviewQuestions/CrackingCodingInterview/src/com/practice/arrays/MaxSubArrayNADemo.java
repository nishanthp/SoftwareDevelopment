package com.practice.arrays;

/**
 * Non adjacent - all positive integers.
 * 
 * @author prakasni
 *
 */
public class MaxSubArrayNADemo {
	public static void main(String[] args) {
		int[] input = { 4, 1, 1, 4, 2, 1 };
		MaxSubArrayNADemo demo = new MaxSubArrayNADemo();
		System.out.println(demo.nonAdjacentSum(input));
	}

	public int nonAdjacentSum(int[] input) {
		int exclusive = 0;
		int inclusive = input[0];
		for (int i = 1; i < input.length; i++) {
			int temp = inclusive;
			inclusive = Math.max(inclusive, exclusive + input[i]);
			exclusive = temp;
		}
		return inclusive;
	}
}
