package com.accpeted.submissions;

public class LongestUniquePath {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	int maxLength = 0;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        getLongestPath(root, root.val);
        return maxLength;
    }
    
    public int getLongestPath(TreeNode root, int pVal) {
        if(root == null) return 0;
        int left = getLongestPath(root.left, root.val);
        int right = getLongestPath(root.right, root.val);
        maxLength = Math.max(maxLength, left+right);
        if (root.val == pVal) return  Math.max(left, right)+1;
        return 0;
    }

}
