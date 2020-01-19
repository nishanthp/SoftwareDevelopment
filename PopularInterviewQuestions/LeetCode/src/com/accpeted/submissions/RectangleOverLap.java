package com.accpeted.submissions;

public class RectangleOverLap {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int computeArea(int A, int B, int C, int D, int E, int F, int G,
			int H) {
		int[][] r1 = {{A, B}, {C, D}};
		int[][] r2 = {{E, F}, {G, H}};
		int total = areaOfRect(r1) + areaOfRect(r2) - overlap(r1, r2);
		return total;
	}

	private int overlap(int[][] r1, int[][] r2) {
		int w1 = Math.min(r1[1][0], r2[1][0]);
		int h1 = Math.min(r1[1][1], r2[1][1]);
		int w2 = Math.max(r1[0][0], r2[0][0]);
		int h2 = Math.max(r1[0][1], r2[0][1]);
		if (w1 > w2 && h1 > h2)
			return (w1 - w2) * (h1 - h2);
		return 0;

	}

	private int areaOfRect(int[][] r1) {
		int width = r1[0][0] - r1[1][0];
		int height = r1[0][1] - r1[1][1];
		return width * height;
	}

}
