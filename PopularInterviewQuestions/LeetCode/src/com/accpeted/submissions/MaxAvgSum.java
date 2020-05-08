package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.List;

public class MaxAvgSum {

	public static void main(String[] args) {
		// Ran on leetcode.
		List<Integer> lsit = new ArrayList<Integer>();
		lsit.toArray(new Integer[lsit.size()]);
	}

	double maxAvg = 0.0;
	public double maximumAverageSubtree(TreeNode root) {
		maximumAverageSubtreeT(root);
		return maxAvg;
	}

	private double[] maximumAverageSubtreeT(TreeNode root) {
		if (root == null)
			return new double[]{0.0, 0.0};
		double[] left = maximumAverageSubtreeT(root.left);
		double[] right = maximumAverageSubtreeT(root.right);
		double runningSum = left[0] + right[0] + root.val;
		double count = left[1] + right[1] + 1;
		maxAvg = Math.max(maxAvg, runningSum / count);
		return new double[]{runningSum, count};
	}

}
