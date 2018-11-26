package com.accpeted.submissions;

import java.util.Stack;

public class FlattenBT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public void flatten(TreeNode root) {
	        Stack<TreeNode> stack = new Stack<TreeNode>();
	        while(root != null || !stack.isEmpty()){
	            if(root.left == null && root.right == null && !stack.isEmpty()){
	                root.right = stack.pop();
	            }else if(root.left != null && root.right != null) {
	                stack.push(root.right);
	                root.right = root.left;
	                root.left = null;
	            } else if (root.left != null){
	                root.right = root.left;
	                root.left = null;
	            }
	            root = root.right;
	        }
	        
	        
	    }

}
