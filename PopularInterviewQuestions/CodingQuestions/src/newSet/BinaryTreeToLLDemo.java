package newSet;

import java.util.LinkedList;

public class BinaryTreeToLLDemo {
	static LinkedList<Node> ll = new LinkedList<Node>();

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

		BinaryTreeToLLDemo d = new BinaryTreeToLLDemo();
		d.convertTreeToLinkedList(n1);

		while (ll.iterator().hasNext()) {
			System.out.println(ll.iterator().next().data);
		}
	}

	public void convertTreeToLinkedList(Node root) {
		if (root == null)
			return;
		ll.addLast(root);
		convertTreeToLinkedList(root.left);
		convertTreeToLinkedList(root.right);
		return;
	}
}
