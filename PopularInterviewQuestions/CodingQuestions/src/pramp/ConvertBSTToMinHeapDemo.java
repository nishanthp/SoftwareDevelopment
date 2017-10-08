package newSet;

import java.util.ArrayList;

import javax.xml.crypto.Data;

public class ConvertBSTToMinHeapDemo {
	static ArrayList<Node> data = new ArrayList<>();

	public static void main(String[] args) {
		Node root = new Node(4);
		Node root1 = new Node(2);
		Node root2 = new Node(6);
		Node root3 = new Node(1);
		Node root4 = new Node(3);
		Node root5 = new Node(5);
		Node root6 = new Node(7);

		root.left = root1;
		root.right = root2;
		
		root1.left = root3;
		root1.right = root4;
		
		root2.left = root5;
		root2.right = root6;
		
		Node newRoot = convertBSTToMinHeap(root);
		System.out.println(newRoot.left.left.data);
		System.out.println(newRoot.left.right.data);
		System.out.println(newRoot.right.right.data);
		
	}

	private static Node convertBSTToMinHeap(Node root) {
		traverseBST(root);
		return createMinHeap(data, 0);
	}

	private static Node createMinHeap(ArrayList<Node> data, int index) {
		if (index >= data.size()) {
			return null;
		}

		Node root = data.get(index);
		int lIndex = 2 * index + 1;
		int rindex = 2 * index + 2;
		root.left = createMinHeap(data, lIndex);
		root.right = createMinHeap(data, rindex);
		return root;
	}

	private static void traverseBST(Node root) {
		if (root == null) {
			return;
		}
		traverseBST(root.left);
		data.add(root);
		traverseBST(root.right);
	}
}
