package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ClosestBSTValue2 {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	// Cannot do it in place. Need a queue. Can be done with priorityQueue if you modify the 
	// TreeNode ds. 
	Deque<Integer> queue = new LinkedList<Integer>();
    List<Integer> result = new LinkedList<Integer>();
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        inorder(root);
        while(queue.size() > k) {
            if(Math.abs(target - queue.peekFirst()) > Math.abs(target-queue.peekLast())) {
                queue.pollFirst();
            } else 
                queue.pollLast();
        }
        return new ArrayList<Integer>(queue);
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        queue.add(root.val);
        inorder(root.right);
    }

}
