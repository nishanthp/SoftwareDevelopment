package com.common.templates;

public class DFS {

	public static void main(String[] args) {
		// 1. DFS on BST and BT.
		// 2. DFS on graph.
		// 3. DFS without recurssion.
		BTNode root = null;
		GraphNode startNode = null;

		DFSOnBinaryTree(root);
		DFSOnGraph(startNode);
	}

	private static void DFSOnBinaryTree(BTNode root) {
		if (root == null)
			return;
		System.out.println(root.val); // pre-order
		DFSOnBinaryTree(root.left);
		System.out.println(root.val); // in-order
		DFSOnBinaryTree(root.right);
		System.out.println(root.val); // post-order

	}

	private static void DFSOnGraph(GraphNode startNode) {
		if (startNode == null)
			return;
		System.out.println(startNode.val); // pre-order
		for (GraphNode curr_neighbor : startNode.neighbors) {
			DFSOnGraph(curr_neighbor);
		}
		// No in-order for a graph.
		System.out.println(startNode.val); // post-order
	}

}
