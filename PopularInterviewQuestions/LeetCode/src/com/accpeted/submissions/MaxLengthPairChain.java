package com.accpeted.submissions;

import java.util.Arrays;
import java.util.Comparator;

public class MaxLengthPairChain {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int findLongestChain(int[][] pairs) {
		Arrays.sort(pairs, new Comparator<int[]>() {
			@Override
			public int compare(int[] n1, int[] n2) {
				return n1[0] == n2[0] ? n1[1] - n2[1] : n1[0] - n2[0];
			}
		});
		int maxLength = 0;
		int j = 1;
		for (int i = 0; i < pairs.length; i++) {
			int[] first = pairs[i];
			int count = 1;
			j = i + 1;
			while (j < pairs.length) {
				int[] second = pairs[j];
				if (first[1] < second[0]) {
					count++;
					first = second;
				} else if (first[1] > second[1]) {
					first = second;
				}
				j++;
			}
			maxLength = Math.max(maxLength, count);
		}
		return maxLength;
	}

}
