package com.accpeted.submissions;

public class InorderSuccessor {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// This is the for BST.
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		TreeNode succ = null;
		while (root != null) {
			// Below line is the reason for no recursion
			if (root.val > p.val) {
				succ = root;
				root = root.left;
			} else
				root = root.right;
		}
		return succ;
	}

	// This is for binary tree.
	TreeNode prev = null;
	public TreeNode inorderSuccessorForBT(TreeNode root, int val, TreeNode p) {
		if (root.right != null)
			inorderSuccessorForBT(root.right, val, p);
		if (root.val == val)
			return prev != null ? prev : null;
		// Below line is the important step.
		prev = root;
		if (root.left != null)
			inorderSuccessorForBT(root.left, val, p);

		return prev;
	}

}
