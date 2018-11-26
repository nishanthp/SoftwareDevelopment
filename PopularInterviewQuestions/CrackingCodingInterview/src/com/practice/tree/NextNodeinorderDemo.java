package com.practice.tree;

import java.util.ArrayList;

public class NextNodeinorderDemo {
	static ArrayList<Integer> data = new ArrayList<>();

	public static void main(String[] args) {
		Node root = new Node(20);
		Node root1 = new Node(8);
		Node root2 = new Node(4);
		Node root3 = new Node(12);
		Node root4 = new Node(10);
		Node root5 = new Node(14);
		Node root6 = new Node(22);
		root.left = root1;
		root.right = root6;
		root1.left = root2;
		root1.right = root3;
		root3.left = root4;
		root3.right = root5;
		NextNodeinorderDemo demo = new NextNodeinorderDemo();
		demo.findNextNode(root, root1);
		Node nextNode = demo.findNextNodeWithoutParent(root, root1);
		System.out.println("First element in array" + data.get(0));
		System.out.println("Next node data." + nextNode.data);
	}

	/*
	 * Simpler version. It works, but do not implement this if asked in
	 * interview.
	 */
	public void findNextNode(Node root, Node currentNode) {
		if (root == null) {
			return;
		}
		findNextNode(root.left, currentNode);
		if (root.data > currentNode.data) {
			data.add(root.data);
		}
		findNextNode(root.right, currentNode);
	}

	public Node findNextNodeWithoutParent(Node root, Node currentNode) {
		if (currentNode.right != null) {
			return findLeftMosrNode(currentNode.right);
		}
		Node previousNode = null;
		while (root != null) {
			if (root.data > currentNode.data) {
				previousNode = root;
				root = root.left;
			} else if (root.data < currentNode.data) {
				root = root.right;
			} else
				break;
		}
		return previousNode;
	}

	private Node findLeftMosrNode(Node currentNode) {
		while (currentNode.left != null) {
			currentNode = currentNode.left;
		}
		return currentNode;

	}
}
