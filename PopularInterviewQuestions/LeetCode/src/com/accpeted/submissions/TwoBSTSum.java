package com.accpeted.submissions;

import java.util.HashSet;
import java.util.Set;

public class TwoBSTSum {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
		Set<Integer> set = new HashSet<Integer>();
		traverse(root1, set);
		return checkTargetSum(root2, set, target);
	}

	private boolean checkTargetSum(TreeNode root, Set<Integer> set,
			int target) {
		if (root == null)
			return false;
		if (set.contains(target - root.val))
			return true;
		return checkTargetSum(root.left, set, target)
				|| checkTargetSum(root.right, set, target);
	}

	private void traverse(TreeNode root, Set<Integer> set) {
		if (root == null)
			return;
		set.add(root.val);
		traverse(root.left, set);
		traverse(root.right, set);
	}

}
