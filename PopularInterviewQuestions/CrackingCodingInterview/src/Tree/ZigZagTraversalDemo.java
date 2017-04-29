package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversalDemo {
	public static void main(String[] args) {
		Node root = new Node(3);
		Node root1 = new Node(9);
		Node root2 = new Node(20);
		Node root3 = new Node(15);
		Node root4 = new Node(7);
		Node root5 = new Node(6);
		Node root6 = new Node(5);
		root.left = root1;
		root.right = root2;
		root1.left = root5;
		root1.right = root6;
		root2.left = root3;
		root2.right = root4;
		int height = heightofTree(root);
		ZigZagTraversalDemo demo = new ZigZagTraversalDemo();
		boolean ltr = false;
		for (int i = 1; i <= height; i++) {
			demo.zigZag(root, i, ltr);
			ltr = !ltr;
		}
	}

	private static int heightofTree(Node root) {
		if (root == null) {
			return 0;
		}
		int left = heightofTree(root.left);
		int right = heightofTree(root.right);
		return 1 + Math.max(left, right);

	}

	public void zigZag(Node root, int level, boolean ltr) {
		if (root == null) {
			return;
		}
		if (level == 1) {
			System.out.println(root.data);
		} else if (level > 1) {
			if (ltr) {
				zigZag(root.left, level - 1, ltr);
				zigZag(root.right, level - 1, ltr);
			} else {
				zigZag(root.right, level - 1, ltr);
				zigZag(root.left, level - 1, ltr);
			}
		}

	}
}
