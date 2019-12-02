package com.common.templates;

public class Intervals {

	public static void main(String[] args) {
		int[][] intervals = {{1, 3}, {4, 5}, {4, 6}};
		overlapIntervals(intervals);
	}

	private static int[] overlapIntervals(int[][] intervals) {
		int[] temp = intervals[0];
		for (int[] eachInterval : intervals) {
			if (temp[1] <= eachInterval[0])
				return new int[]{temp[1], eachInterval[0]};
			if (temp[1] > eachInterval[0]) // merge them.
				temp = new int[]{Math.min(eachInterval[0], temp[0]),
						Math.max(eachInterval[1], temp[1])};
		}
		return new int[]{-1, -1};
	}

}
