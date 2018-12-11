package com.accpeted.submissions;

public class FlipEquivalentBT {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        if(root1.val != root2.val) return false;
        if (flipEquiv(root1.left, root2.left))  {
            if (flipEquiv(root1.right, root2.right))  return true;
            else return false;
        } else if (flipEquiv(root1.left, root2.right)) {
            if (flipEquiv(root1.right, root2.left)) return true;
            else return false;
        }
       return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
    }

}
