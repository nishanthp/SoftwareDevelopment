package com.accpeted.submissions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class QueueReconstrctionByHeight {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] n1, int[] n2) {
				return n1[0] == n2[0] ? n1[1] - n2[1] : n2[0] - n1[0];
			}
		});

		List<int[]> result = new LinkedList<>();
		for (int[] p : people) {
			result.add(p[1], p);
		}
		return result.toArray(new int[people.length][2]);
	}

}
