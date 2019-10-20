package com.accpeted.submissions;

import java.util.HashMap;

public class BTFromInorderPreOrder {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		HashMap<Integer, Integer> inOrderMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			inOrderMap.put(inorder[i], i);
		}
		return buildTree(preorder, inorder, inOrderMap, 0, 0,
				preorder.length - 1, inorder.length - 1);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder,
			HashMap<Integer, Integer> inOrderMap, int preStart, int inStart,
			int preEnd, int inEnd) {
		if (preStart > preEnd || inStart > inEnd)
			return null;

		TreeNode root = new TreeNode(preorder[preStart]);
		int rootIndex = inOrderMap.get(root.val);
		int leftElements = rootIndex - inStart;
		root.left = buildTree(preorder, inorder, inOrderMap, preStart + 1,
				inStart, preEnd, rootIndex - 1);
		root.right = buildTree(preorder, inorder, inOrderMap,
				preStart + leftElements + 1, rootIndex + 1, preEnd, inEnd);
		return root;

	}

}
