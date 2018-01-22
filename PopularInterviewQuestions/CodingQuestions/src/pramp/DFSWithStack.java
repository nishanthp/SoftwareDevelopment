package pramp;

import java.util.Stack;

public class DFSWithStack {
	public static void main(String[] args) {
		Node root = new Node(4);
		Node root1 = new Node(5);
		Node root2 = new Node(6);
		Node root3 = new Node(7);

		root.left = root1;
		root.right = root2;
		root2.right = root3;

		dfs(root);
	}

	public static void dfs(Node root) {
		Node current = root;
		Stack<Node> stack = new Stack<Node>();
		stack.push(current);
		while (!stack.isEmpty()) {
			Node temp = stack.pop();
			if (temp.right != null) {
				stack.push(temp.right);
			}
			System.out.println(temp.data);
			if (temp.left != null) {
				stack.push(temp.left);
			}
		}
	}
}
