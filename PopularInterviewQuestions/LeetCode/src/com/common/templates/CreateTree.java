package com.common.templates;

public class CreateTree {

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4, 5, 6};
		TreeNode root = createBST(input, 0, input.length);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
	}

	private static TreeNode createBST(int[] input, int low, int high) {
		if (low >= high)
			return null;
		int mid = (low + high) / 2;
		TreeNode root = new TreeNode(input[mid]);
		root.left = createBST(input, low, mid - 1);
		root.right = createBST(input, mid + 1, high);
		return root;
	}

}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	public TreeNode(int data) {
		this.val = data;
	}
}
