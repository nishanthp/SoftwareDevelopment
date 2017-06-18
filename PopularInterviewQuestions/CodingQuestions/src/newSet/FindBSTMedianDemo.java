package newSet;

import java.util.ArrayList;

public class FindBSTMedianDemo {
	ArrayList<Integer> nodes = new ArrayList<>();

	public static void main(String[] args) {
		Node root = new Node(6);
		Node root1 = new Node(3);
		Node root2 = new Node(8);
		Node root3 = new Node(1);
		Node root4 = new Node(4);
		Node root5 = new Node(7);
		Node root6 = new Node(9);

		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;

		root2.left = root5;
		//root2.right = root6;

		FindBSTMedianDemo d = new FindBSTMedianDemo();
		int median = d.median(root);
		System.out.println(median);
	}

	public int median(Node root) {
		inOrderTraversal(root);
		int numberOfnodes = nodes.size();
		if (numberOfnodes % 2 == 0) {
			int i = numberOfnodes / 2;
			int m1 = nodes.get(i - 1);
			int m2 = nodes.get(i);
			return (m1 + m2) / 2;
		} else {
			int i = (numberOfnodes + 1) / 2;
			return nodes.get(i - 1);
		}
	}

	private void inOrderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inOrderTraversal(root.left);
		nodes.add(root.data);
		inOrderTraversal(root.right);

	}
}
