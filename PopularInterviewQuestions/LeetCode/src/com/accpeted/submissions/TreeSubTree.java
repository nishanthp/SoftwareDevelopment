package com.accpeted.submissions;

public class TreeSubTree {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	 public boolean isSubtree(TreeNode s, TreeNode t) {
	        if(s == null) return false;
	        if(t == null) return true;
	        return isSubtreeT(s, t);
	    }
	    
	    public boolean isSubtreeT(TreeNode s, TreeNode t) {
	        if(s==null) return false;
	        if(s.val == t.val) {
	            if (checkTree(s, t)) return true;
	        }
	        return isSubtreeT(s.left, t) || isSubtreeT(s.right, t);
	    }
	    
	    public boolean checkTree(TreeNode s, TreeNode t) {
	        if(t == null && s == null) return true;
	        if(t == null || s == null) return false;
	        if(s.val != t.val) return false;
	        return checkTree(s.left, t.left) && checkTree(s.right, t.right);
	    }

}
