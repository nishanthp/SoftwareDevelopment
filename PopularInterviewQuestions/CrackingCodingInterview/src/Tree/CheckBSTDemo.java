package Tree;

public class CheckBSTDemo {
	Boolean isBST = Boolean.TRUE;
	Node previousNode;

	public static void main(String[] args) {
		Node root = new Node(16);
		Node root5 = new Node(17);
		Node root1 = new Node(12);
		Node root2 = new Node(15);
		Node root3 = new Node(14);
		Node root4 = new Node(19);
		root.left = root3;
		root.right = root4;
		root3.left = root1;
		root3.right = root2;
		root4.left = root5;

		CheckBSTDemo bst = new CheckBSTDemo();
		/*
		 * Boolean isitBST = bst.checkifBinaryTree(root);
		 * System.out.println(isitBST);
		 */
		// Another way.
		Boolean anotherWay = bst.checkifBinaryTreeAnotherWay(root);
		System.out.println(anotherWay);

	}

	public Boolean checkifBinaryTree(Node root) {
		if (root == null) {
			return Boolean.TRUE;
		}
		checkifBinaryTree(root.left);
		if (root.left != null) {
			if (root.left.data > root.data) {
				isBST = Boolean.FALSE;
				return isBST;
			}
		}
		checkifBinaryTree(root.right);
		if (root.right != null) {
			if (root.right.data < root.data) {
				isBST = Boolean.FALSE;
				return isBST;
			}

		}
		return isBST;
	}

	// Another Way.
	public Boolean checkifBinaryTreeAnotherWay(Node root) {
		if (root == null) {
			return true;
		}
		if (!checkifBinaryTreeAnotherWay(root.left)) {
			return false;
		}
		if (previousNode != null && root.data <= previousNode.data) {
			return false;
		}
		previousNode = root;
		if (!checkifBinaryTreeAnotherWay(root.right)) {
			return false;
		}
		return true;
	}
}
