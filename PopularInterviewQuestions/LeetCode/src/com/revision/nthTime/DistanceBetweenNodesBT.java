package com.revision.nthTime;

public class DistanceBetweenNodesBT {

	public static void main(String[] args) {

	}

	public static int findNode(Node root, Node p, int count) {
		if (root == null)
			return 0;
		if (p.val == root.val)
			return count;

		findNode(root.left, p, count + 1);
		findNode(root.left, p, count + 1);

		return 0;

	}

	class Node {
		Node left;
		Node right;
		int val;
		Node(int val) {
			this.val = val;
		}
	}

}
