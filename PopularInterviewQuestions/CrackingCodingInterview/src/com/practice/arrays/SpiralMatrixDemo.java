package com.practice.arrays;

public class SpiralMatrixDemo {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		SpiralMatrixDemo demo = new SpiralMatrixDemo();
		demo.spiralMatrixPrint(a, a.length, a[0].length);
	}

	public void spiralMatrixPrint(int a[][], int r, int c) {
		int k = 0;
		int m = r;
		int l = 0;
		int n = c;
		while (k < m && l < n) {
			// print 1st row.
			for (int i = l; i < n; ++i) {
				System.out.println(a[k][i]);
			}
			k++;

			// print last column.
			for (int i = k; i < m; ++i) {
				System.out.println(a[i][n - 1]);
			}
			n--;

			// print last row.
			if (k < m) {
				for (int i = n - 1; i >= l; --i) {
					System.out.println(a[m - 1][i]);
				}
				m--;
			}

			// print 1st column.
			if (l < n) {
				for (int i = m - 1; i >= k; --i) {
					System.out.println(a[i][l]);
				}
				l++;
			}

		}
	}
}
