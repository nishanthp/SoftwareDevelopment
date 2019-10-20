package com.accpeted.submissions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AllNodesDistK {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	HashMap<TreeNode, TreeNode> nodeToParentMap = new HashMap<TreeNode, TreeNode>();
	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		buildMap(root, null);
		List<Integer> res = new LinkedList<Integer>();
		HashSet<TreeNode> visited = new HashSet<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(target);
		visited.add(target);
		int counter = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			if (counter == K)
				break;
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();

				if (curr.left != null && !visited.contains(curr.left)) {
					visited.add(curr.left);
					queue.offer(curr.left);
				}

				if (curr.right != null && !visited.contains(curr.right)) {
					visited.add(curr.right);
					queue.offer(curr.right);
				}

				TreeNode parent = nodeToParentMap.getOrDefault(curr, null);
				if (parent != null && !visited.contains(parent)) {
					visited.add(parent);
					queue.offer(parent);
				}
			}
			counter += 1;
		}
		while (!queue.isEmpty()) {
			res.add(queue.remove().val);
		}
		return res;
	}

	public void buildMap(TreeNode root, TreeNode parent) {
		if (root == null)
			return;
		nodeToParentMap.putIfAbsent(root, parent);
		buildMap(root.left, root);
		buildMap(root.right, root);
	}

}
