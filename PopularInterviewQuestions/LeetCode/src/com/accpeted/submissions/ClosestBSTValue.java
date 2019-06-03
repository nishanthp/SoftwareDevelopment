package com.accpeted.submissions;

public class ClosestBSTValue {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	double closest = Double.MAX_VALUE;
    int res = 0;
    public int closestValue(TreeNode root, double target) {
        closestValueT(root, target);
        return res;
    }
    
    public void closestValueT(TreeNode root, double target) {
        if(root == null) return;
        double d = Math.abs(target - root.val);
        if(d < closest) {
            closest = d;
            res=root.val;
        }
        closestValueT(root.left, target);
        closestValueT(root.right, target);
    }

}
