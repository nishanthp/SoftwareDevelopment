package com.accpeted.submissions;

public class PathSum2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean hasPathSum(TreeNode root, int sum) {
		int treeHeight = heightOfTree(root);
		int[] path = new int[treeHeight];
		if (treeHeight > 0)
			return addPath(root, path, 0, sum);
		return false;

	}

	public int heightOfTree(TreeNode root) {
		if (root == null)
			return 0;
		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);
		return 1 + Math.max(left, right);
	}

	public boolean addPath(TreeNode root, int[] path, int level, int targetSum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null) {
			path[level] = root.val;
			int sumSoFar = 0;
			// Add the path till now.
			for (int i = level; i >= 0; i--) {
				sumSoFar += path[i];
			}
			if (sumSoFar == targetSum)
				return true;
			return false;
		}
		path[level] = root.val;
		return (addPath(root.left, path, level + 1, targetSum) || addPath(root.right, path, level + 1, targetSum));

	}
}
