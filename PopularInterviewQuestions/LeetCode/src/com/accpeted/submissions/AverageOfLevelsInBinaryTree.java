package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> averages = new LinkedList<Double>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			double sum = 0;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode current = queue.poll();
				if (current.left != null)
					queue.offer(current.left);
				if (current.right != null)
					queue.offer(current.right);
				sum += current.val;
			}
			averages.add(sum / (double) size);
		}
		return averages;
	}
}
