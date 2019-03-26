package com.accpeted.submissions;

import java.util.Deque;
import java.util.LinkedList;

public class FindBottomLeftTreeVal {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        Deque<Integer> bottomVal = new LinkedList<Integer>();
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode curr = queue.remove();
                if(i==0) bottomVal.offerFirst(curr.val);
                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return bottomVal.poll();
    }

}
