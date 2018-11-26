package com.accpeted.submissions;

public class LCABT {

	public static void main(String[] args) {
		// TODO Ran on leetcode.

	}
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == null || p == null || q == null) return null;
	        if (root.val == p.val || root.val == q.val) return root;
	        boolean p_on_left = searchTree(root.left, p);
	        boolean q_on_left = searchTree(root.left, q);
	        if(p_on_left != q_on_left) return root;
	        if(p_on_left) return lowestCommonAncestor(root.left, p, q);       
	        else return lowestCommonAncestor(root.right, p, q); 
	        
	    }
	    
	     public boolean searchTree(TreeNode root, TreeNode p){
	        if(root == null) return false;
	        if(root.val == p.val) return true;
	        return searchTree(root.left,  p) || searchTree(root.right,  p);
	    }

}
