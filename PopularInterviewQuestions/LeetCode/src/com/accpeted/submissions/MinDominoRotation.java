package com.accpeted.submissions;

public class MinDominoRotation {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int minDominoRotations(int[] A, int[] B) {
		int minValue = Integer.MAX_VALUE;
		minValue = Math.min(numOfRotations(A[0], A, B),
				numOfRotations(A[0], B, A));
		minValue = Math.min(minValue, Math.min(numOfRotations(B[0], A, B),
				numOfRotations(B[0], B, A)));
		return minValue == Integer.MAX_VALUE ? -1 : minValue;
	}

	private int numOfRotations(int target, int[] A, int[] B) {
		int numOfRotations = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] != target && B[i] != target) {
				return Integer.MAX_VALUE;
			}
			if (A[i] != target) {
				numOfRotations++;
			}
		}
		return numOfRotations;
	}

}
