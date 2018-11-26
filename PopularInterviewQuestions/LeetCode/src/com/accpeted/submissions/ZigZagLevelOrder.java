package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrder {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Without recursion, using BFS.
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null)
			return new LinkedList<>();
		List<List<Integer>> lists = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int currentSize = queue.size();
			ArrayList<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < currentSize; i++) {
				TreeNode curr = queue.poll();
				list.add(curr.val);
				if (curr.left != null)
					queue.add(curr.left);
				if (curr.right != null)
					queue.add(curr.right);
			}
			if (level % 2 != 0)
				Collections.reverse(list);
			level += 1;
			lists.add(list);
		}
		return lists;
	}

}
