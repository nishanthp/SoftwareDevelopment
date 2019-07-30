package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WidthOfBinaryTree {

	public static void main(String[] args) {
		// Ran on leetcode.
		List<Integer> red = new ArrayList<>();
		red.toArray(new Integer[red.size()]);
	}
	
	
	public int widthOfBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> queueIndex = new LinkedList<Integer>();
        queue.offer(root);
        queueIndex.offer(1);
        int maxWidth = 0;
        int start = 0;
        int end = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                int currIndex = queueIndex.poll();
                if(i == 0) start = currIndex;
                if(i == size-1) end = currIndex;
                if(temp.left != null) {
                    queue.offer(temp.left);
                    // this is the important part.
                    queueIndex.offer(2*currIndex);
                }
                if(temp.right != null) {
                    queue.offer(temp.right);
                 // this is the important part.
                    queueIndex.offer(2*currIndex+1);
                }
            }
            maxWidth = Math.max(maxWidth, end-start+1);
        }
        return maxWidth;
    }

}
