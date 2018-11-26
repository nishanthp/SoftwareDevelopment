package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main() {
		// Ran on leetcode.
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		// Please declare queue like below.
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		// Please look at the below declaration. Cannot do
		// LinkedList<LinkedList<Integer>>
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if (root == null)
			return lists;
		queue.add(root);
		int height = 0;
		while (!queue.isEmpty()) {
			// This is important. This could be used to do BFS on tree. This
			// determines the number of nodes at each level.
			int size = queue.size();
			if (height >= lists.size()) {
				lists.add(new LinkedList<Integer>());
			}
			List<Integer> list = lists.get(height);
			// add the nodes values in that level.
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				list.add(current.val);
				if (current.left != null)
					queue.add(current.left);
				if (current.right != null)
					queue.add(current.right);
			}
			height += 1;
		}
		return lists;
	}
}
