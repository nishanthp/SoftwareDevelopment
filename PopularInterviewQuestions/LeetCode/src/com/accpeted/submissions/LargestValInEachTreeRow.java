package com.accpeted.submissions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LargestValInEachTreeRow {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<Integer>();
        if(root == null) return result;
        Deque<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            int maxValue = Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                TreeNode curr = queue.poll();
                maxValue = Math.max(maxValue, curr.val);
                if(curr.left != null) queue.offer(curr.left);
                 if(curr.right != null) queue.offer(curr.right);
            }
            result.add(maxValue);
        }
        return result;
    }

}
