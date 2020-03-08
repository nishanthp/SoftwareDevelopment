package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructFromPreOrder {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public TreeNode bstFromPreorder(int[] preorder) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode root = new TreeNode(preorder[0]);
		stack.push(root);
		for (int i = 1; i < preorder.length; i++) {
			TreeNode child = new TreeNode(preorder[i]);
			TreeNode parent = stack.peek();
			while (!stack.isEmpty() && stack.peek().val < child.val) {
				parent = stack.pop();
			}
			if (parent.val < child.val)
				parent.right = child;
			else {
				parent.left = child;
			}
			stack.push(child);
		}
		return root;
	}

}
