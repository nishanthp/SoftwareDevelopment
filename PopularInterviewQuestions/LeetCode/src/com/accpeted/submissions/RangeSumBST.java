package com.accpeted.submissions;

public class RangeSumBST {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	 int runningSum = 0;
	    public int rangeSumBST(TreeNode root, int L, int R) {
	        traverse(root,  L,  R);
	        return runningSum;
	    }

	    public void traverse(TreeNode root, int L, int R) {
	        if(root == null) return;
	        if(root.val >= L && root.val <= R)runningSum += root.val;
	        traverse(root.left, L,  R);
	        traverse(root.right, L,  R);
	    }

}
