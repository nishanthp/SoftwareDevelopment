package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.Queue;

public class CompletenessBT {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean isCompleteTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		boolean inComplete = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (curr.left == null && curr.right != null)
					return false;
				if (inComplete && (curr.left != null || curr.right != null))
					return false;
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
				if (curr.right == null)
					inComplete = true;
			}
		}
		return true;
	}

}
