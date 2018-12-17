package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.List;

public class PrintAllPaths {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public List<String> binaryTreePaths(TreeNode root) {
		ArrayList<String> paths = new ArrayList<String>();
		addPaths(root, "", paths);
		return paths;
	}

	public void addPaths(TreeNode root, String path, ArrayList<String> paths) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			paths.add(path + root.val);
			return;
		}
		addPaths(root.left, path + root.val + "->", paths);
		addPaths(root.right, path + root.val + "->", paths);
	}

}
