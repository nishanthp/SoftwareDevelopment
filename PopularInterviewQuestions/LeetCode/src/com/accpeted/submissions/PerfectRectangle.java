package com.accpeted.submissions;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// One of those problems.
	public boolean isRectangleCover(int[][] rectangles) {
		int x1 = Integer.MAX_VALUE;
		int y1 = Integer.MAX_VALUE;
		int x2 = Integer.MIN_VALUE;
		int y2 = Integer.MIN_VALUE;
		int totalArea = 0;
		Set<String> set = new HashSet<String>();
		for (int[] rectangle : rectangles) {
			x1 = Math.min(rectangle[0], x1);
			y1 = Math.min(rectangle[1], y1);
			x2 = Math.max(rectangle[2], x2);
			y2 = Math.max(rectangle[3], y2);
			totalArea += (rectangle[2] - rectangle[0])
					* (rectangle[3] - rectangle[1]);
			String oneCorner = rectangle[0] + " " + rectangle[1];
			String twoCorner = rectangle[0] + " " + rectangle[3];
			String threeCorner = rectangle[2] + " " + rectangle[1];
			String fourCorner = rectangle[2] + " " + rectangle[3];
			if (!set.add(oneCorner))
				set.remove(oneCorner);
			if (!set.add(twoCorner))
				set.remove(twoCorner);
			if (!set.add(threeCorner))
				set.remove(threeCorner);
			if (!set.add(fourCorner))
				set.remove(fourCorner);
		}
		System.out.println(set.contains(x2 + " " + y1));
		System.out.println(set.contains(x1 + " " + y1));
		System.out.println(set.contains(x2 + " " + y2));
		System.out.println(set.contains(x1 + " " + y2));
		System.out.println(((y2 - y1)));

		if (set.contains(x1 + " " + y1) && set.contains(x1 + " " + y2)
				&& set.contains(x2 + " " + y1) && set.contains(x2 + " " + y2)
				&& set.size() == 4 && totalArea == (x2 - x1) * (y2 - y1)) {
			return true;
		}

		return false;
	}

}
