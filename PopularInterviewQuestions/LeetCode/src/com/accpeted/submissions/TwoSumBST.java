package com.accpeted.submissions;

import java.util.HashSet;

public class TwoSumBST {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	HashSet<Integer> set = new HashSet<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        if(set.contains(k-root.val)) return true;
        else set.add(root.val);
        return findTarget(root.left, k) || findTarget(root.right, k);
            
    }

}
