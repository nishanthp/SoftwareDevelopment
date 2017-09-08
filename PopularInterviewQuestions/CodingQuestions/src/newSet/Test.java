package newSet;

import java.util.ArrayList;

public class Test { 
	public static void main(String[] args) {
		int[] input = { 4, 2, 5, 1 };
		Node result_node = traverseLinkedList(null, input, 0);
		System.out.println(result_node.left.left.data);
	}

	// insert in order of array.
	private static Node traverseLinkedList(Node root, int[] input, int index) {
		if (index > input.length - 1) {
			return null;
		}

		if (root == null) {
			root = new Node(input[index]);
		}

		root.left = traverseLinkedList(root.left, input, (2 * index) + 1);
		root.right = traverseLinkedList(root.right, input, (2 * index) + 2);
		return root;
	}
	
	private static Node Depth(Node root, int level){
		
	}
}
