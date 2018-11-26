package com.accpeted.submissions;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	int max = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		diameterTree(root);
		return max;
	}

	public int diameterTree(TreeNode root) {
		if (root == null)
			return 0;
		int left = diameterTree(root.left);
		int right = diameterTree(root.right);
		max = Math.max(left + right, max);
		return Math.max(left, right) + 1;
	}

}
