package com.accpeted.submissions;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class IncreasingOrderSearchTree {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	 public TreeNode increasingBST(TreeNode root) {
		    StringBuilder sb = new StringBuilder();
		    String s = serialize(root,sb);
		    String[] nodes = s.split(",");
		    Deque<String> q = new LinkedList<String>();
			q.addAll(Arrays.asList(s.split(",")));
		    return deserialize(q);
		    }
		    
		    public String serialize(TreeNode root, StringBuilder sb){
		        if(root == null){
		            return sb.toString();
		        }
		        serialize(root.left, sb);
		        sb.append(String.valueOf(root.val)).append(",");
		        serialize(root.right, sb);
		        return sb.toString();  
		    }
		    
		    public TreeNode deserialize(Deque<String> nodes){
		        if(nodes.size() == 0) return null;
		        TreeNode root = new TreeNode(Integer.valueOf(nodes.remove()));
		        root.right =  deserialize(nodes);
		        return root;                             
		    }

}
