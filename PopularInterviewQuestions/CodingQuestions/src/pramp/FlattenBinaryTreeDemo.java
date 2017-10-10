package pramp;

import java.util.LinkedList;
import java.util.Stack;

public class FlattenBinaryTreeDemo {

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);

		n1.left = n2;
		n1.right = n5;

		n2.left = n3;
		n2.right = n4;

		n5.left = n6;
		n5.right = n7;

		FlattenBinaryTreeDemo d = new FlattenBinaryTreeDemo();
		Node root = d.flattenBinaryTree(n1);
		while (root != null) {
			System.out.println(root.data);
			root = root.right;
		}
	}

	public Node flattenBinaryTree(Node root) {
		Node p = root;
		Stack<Node> stack = new Stack<>();
		while (p != null || !stack.isEmpty()) {
			if (p.right != null) {
				stack.push(p);
			}
			if (p.left != null) {
				p.right = p.left;
				p.left = null;
			} else if (!stack.isEmpty()) {
				p.right = stack.pop();
			}
			p = p.right;
		}
		return root;
	}
}
