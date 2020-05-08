package com.accpeted.submissions;

public class LCADeepLeaves {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	TreeNode lca = null;
	int deepest = 0;
	public TreeNode lcaDeepestLeaves(TreeNode root) {
		lca(root, 0);
		return lca;
	}

	public int lca(TreeNode root, int depth) {
		deepest = Math.max(deepest, depth);
		if (root == null)
			return depth;
		int left = lca(root.left, depth + 1);
		int right = lca(root.right, depth + 1);
		if (left == deepest && right == deepest)
			lca = root;
		return Math.max(left, right);
	}

}
