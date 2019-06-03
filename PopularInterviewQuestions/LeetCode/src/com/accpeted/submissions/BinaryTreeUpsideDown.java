package com.accpeted.submissions;

public class BinaryTreeUpsideDown {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	
	public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return root;
        // Only the underlying structure changes.
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        // Important point is, this never changes. 
        return newRoot;
    }

}
