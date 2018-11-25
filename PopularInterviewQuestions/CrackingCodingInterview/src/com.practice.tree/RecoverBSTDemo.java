package tree;

public class RecoverBSTDemo {
	static Node prev = null;
	static Node n1 = null;
	static Node n2 = null;

	public static void main(String[] args) {
		Node root = new Node(10);
		Node root1 = new Node(5);
		Node root2 = new Node(12);
		Node root3 = new Node(6);
		Node root4 = new Node(7);

		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;

		inorderTraversal(root);
		if (n1 != null && n2 != null) {
			int temp = n1.data;
			n1.data = n2.data;
			n2.data = temp;
		}
		System.out.println(root.left.data);
	}

	private static void inorderTraversal(Node root) {
		if (root == null) {
			return;
		}
		inorderTraversal(root.left);
		if (prev == null) {
			prev = root;
		} else if (root.data < prev.data) {
			n1 = prev;
			n2 = root;
			prev = root;
		}
		inorderTraversal(root.right);
	}
}
