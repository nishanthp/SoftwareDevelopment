package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.Queue;

public class Cousins {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isXSeen = false;
        boolean isYSeen = false;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                if(curr.val == x) isXSeen = true;
                if(curr.val == y) isYSeen = true;
                if(curr.left != null && curr.right != null) {
                    if(curr.left.val == x && curr.right.val == y || curr.left.val == y && curr.right.val == x) return false;
                }
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
            if(isXSeen && isYSeen) return true;
            if(isXSeen || isYSeen) return false;
        }
        return false;
    }

}
