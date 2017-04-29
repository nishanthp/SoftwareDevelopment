package Tree;

public class PrintAllLeavesofTreeDemo {
	public static void main(String[] args) {
		Node root = new Node(10);
		Node root1 = new Node(11);
		Node root2 = new Node(12);
		Node root3 = new Node(13);
		Node root4 = new Node(14);
		Node root5 = new Node(15);
		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root2.left = root4;
		root2.right = root5;
		printAllLeaves(root);
	}

	private static void printAllLeaves(Node root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			System.out.println(root.data);
		}
		printAllLeaves(root.left);
		printAllLeaves(root.right);

	}
}
