package newSet;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeBSTDemo {
	static ArrayList<Integer> numbers = new ArrayList<>();

	public static void main(String[] args) {
		// 1st Tree
		Node root1 = new Node(3);
		Node root11 = new Node(1);
		Node root12 = new Node(4);
		root1.left = root11;
		root1.right = root12;
		// 2nd Tree
		Node root2 = new Node(6);
		Node root21 = new Node(5);
		Node root22 = new Node(7);
		root2.left = root21;
		root2.right = root22;

		Node root = mergeTree(root1, root2);
		numbers.clear();
		System.out.println(root.left.right.data);
		serialize(root);
	}

	private static Node mergeTree(Node root1, Node root2) {
		serialize(root1);
		serialize(root2);
		Integer[] temp = new Integer[numbers.size() - 1];
		temp = numbers.toArray(temp);
		Arrays.sort(temp);
		int left = 0;
		int right = temp.length;
		return deserialize(temp, left, right);
	}

	private static Node deserialize(Integer[] temp, int left, int right) {
		Node root = null;

		if (left < right) {
			int mid = (left + right) / 2;
			root = new Node(temp[mid]);
			root.left = deserialize(temp, left, mid);
			root.right = deserialize(temp, mid + 1, right);
		}
		return root;

	}

	private static void serialize(Node root) {
		if (root == null) {
			return;
		}
		serialize(root.left);
		numbers.add(root.data);
		serialize(root.right);
	}
}
