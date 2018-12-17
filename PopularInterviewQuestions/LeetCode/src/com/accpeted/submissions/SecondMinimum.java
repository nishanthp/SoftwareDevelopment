package com.accpeted.submissions;

public class SecondMinimum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findSecondMinimumValue(TreeNode root) {
        if(root == null || root.left == null || root.right == null) return -1;
        int left = root.val == root.left.val ? findSecondMinimumValue(root.left) : root.left.val;
        int right = root.val == root.right.val ? findSecondMinimumValue(root.right) : root.right.val;
        return left == -1 || right == -1 ? Math.max(left, right) : Math.min(left, right);
            
    }
}
