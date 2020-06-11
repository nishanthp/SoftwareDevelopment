package com.accpeted.submissions;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TimeDiff {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int findMinDifference(List<String> timePoints) {
		List<Integer> mins = new LinkedList<Integer>();
		for (String timePoint : timePoints) {
			String[] temp = timePoint.split(":");
			mins.add(Integer.valueOf(temp[0]) * 60 + Integer.valueOf(temp[1]));
		}
		Collections.sort(mins);

		int minDifference = Integer.MAX_VALUE;
		for (int i = 1; i < mins.size(); i++) {
			minDifference = Math.min(minDifference,
					mins.get(i) - mins.get(i - 1));
		}
		int corner = mins.get(0) + (1440 - mins.get(mins.size() - 1));
		minDifference = Math.min(minDifference, corner);
		return minDifference;
	}

}
