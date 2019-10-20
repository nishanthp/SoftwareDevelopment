package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeVerticalOrder {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> results = new LinkedList<>();
		if (root == null)
			return results;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		Queue<Integer> indexes = new LinkedList<Integer>();
		nodes.add(root);
		indexes.add(0);
		map.put(0, new ArrayList<Integer>());
		int min = 0;
		int max = 0;
		while (!nodes.isEmpty()) {
			int size = nodes.size();
			for (int i = 0; i < size; i++) {
				TreeNode curr = nodes.poll();
				int currIndex = indexes.poll();
				map.putIfAbsent(currIndex, new ArrayList<Integer>());
				map.get(currIndex).add(curr.val);
				if (curr.left != null) {
					nodes.add(curr.left);
					indexes.add(currIndex - 1);
					min = Math.min(min, currIndex - 1);
				}
				if (curr.right != null) {
					nodes.add(curr.right);
					indexes.add(currIndex + 1);
					max = Math.max(max, currIndex + 1);
				}
			}
		}
		for (int i = min; i <= max; i++) {
			results.add(map.get(i));
		}

		return results;
	}

}
