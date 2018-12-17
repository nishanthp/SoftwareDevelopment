package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BTLevelOrderTraversal2 {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();
        if (root == null) return lists;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.remove();
                list.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            lists.add(0, list);
        }
        return lists;
    }

}
