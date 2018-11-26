package com.practice.bitManipulation;

public class InsertionDemo {
	public static void main(String[] args) {
		int m = Integer.parseInt("10011", 2);
		int n = Integer.parseInt("10000000000", 2);
		String s = Integer.toBinaryString(inserMintoN(m, n, 2, 6));
		System.out.println(s);
	}

	private static int inserMintoN(int m, int n, int i, int j) {
		int m_shifted = m << i;
		int r_mask = 1 << i;
		r_mask = r_mask - 1;
		int l_mask = -1 << j;
		int result_mask = l_mask | r_mask;
		int n_new = n & result_mask;
		return (n_new | m_shifted);
	}
}
