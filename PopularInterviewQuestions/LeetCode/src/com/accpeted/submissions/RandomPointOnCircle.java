package com.accpeted.submissions;

import java.util.Random;

public class RandomPointOnCircle {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	class Solution {
		double x_c;
		double y_c;
		double r;
		Random random;
		public Solution(double radius, double x_center, double y_center) {
			x_c = x_center;
			y_c = y_center;
			r = radius;
			random = new Random();
		}

		public double[] randPoint() {
			double[] res = new double[2];
			double xOrigin = x_c - r;
			double yOrigin = y_c - r;

			while (true) {
				double x = xOrigin + (random.nextDouble() * 2 * r);
				double y = yOrigin + (random.nextDouble() * 2 * r);
				if (Math.sqrt(
						Math.pow(x - x_c, 2) + Math.pow(y - y_c, 2)) <= r) {
					return new double[]{x, y};
				}
			}

		}
	}

}
