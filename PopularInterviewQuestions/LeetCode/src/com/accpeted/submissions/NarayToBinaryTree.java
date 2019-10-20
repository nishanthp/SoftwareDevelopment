package com.accpeted.submissions;

import java.util.List;
import java.util.ArrayList;

public class NarayToBinaryTree {

	public static void main(String[] args) {
		// Ran on leetcode
	}
	
	// Encodes an n-ary tree to a binary tree.
    public TreeNode encode(Node root) {
        if(root == null) return null;
        TreeNode curr = new TreeNode(root.val);
        if(root.children == null || root.children.size() == 0) return curr;
        curr.right = encode(root.children.get(0));
        TreeNode r = curr.right;
        for(int i=1;i<root.children.size();i++){
            r.left = encode(root.children.get(i));
            r = r.left; 
        }
        return curr;
    }

    // Decodes your binary tree to an n-ary tree.
    public Node decode(TreeNode root) {
        if(root == null) return null;
        Node curr = new Node(root.val, new ArrayList<Node>());
        if(root.right == null) return curr;
        curr.children.add(decode(root.right));
        TreeNode remaining = root.right;       
        while(remaining.left != null) {
            curr.children.add(decode(remaining.left));
            remaining = remaining.left;
        }
        return curr;
    }
    
    class Node {
         int val;
         List<Node> children;

         Node() {}

         Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    
    
      
      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
     

}
