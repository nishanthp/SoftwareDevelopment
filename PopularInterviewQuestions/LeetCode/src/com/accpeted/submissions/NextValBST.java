package com.accpeted.submissions;

public class NextValBST {
	static int nextVal= Integer.MIN_VALUE;

	public static void main(String[] args) {
		// Ran on leetcode
		TreeNode root = new TreeNode(20);
		TreeNode left = new TreeNode(10);
		TreeNode right = new TreeNode(30);
		root.left = left;
		root.right = right;
		nextValBST(root, 9);
		System.out.println(nextVal);

	}
	
	public static void nextValBST(TreeNode root, int target){
		if(root == null)return;
		if(target > root.val){
			nextValBST(root.right, target);
		}else if(target < root.val){
			System.out.println(root.val);
			TreeNode leftMostNode = checkLeftMost(root);
			nextVal = leftMostNode.val;
			
		}		
		
	}
	
	public static TreeNode checkLeftMost(TreeNode root){
		if(root == null) return null;
		checkLeftMost(root.left);
		return root;
	}

}
