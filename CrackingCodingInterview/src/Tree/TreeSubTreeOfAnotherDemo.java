package Tree;

public class TreeSubTreeOfAnotherDemo {
	public static void main(String[] args) {
		// Larger Tree.
		Node root1 = new Node(10);
		Node root11 = new Node(12);
		Node root12 = new Node(11);
		Node root13 = new Node(4);
		Node root14 = new Node(3);
		Node root15 = new Node(1);
		Node root16 = new Node(2);
		Node root17 = new Node(5);
		Node root18 = new Node(6);
		Node root19 = new Node(7);
		root1.left = root11;
		root1.right = root12;
		root11.left = root13;
		root11.right = root14;
		root13.left = root15;
		root13.right = root16;
		root14.left = root17;
		root14.right = root18;
		root12.left = root19;
		// Smaller Tree.
		Node root2 = new Node(11);
		Node root21 = new Node(7);
		Node root22 = new Node(3);
		root2.left = root21;
		//root2.right = root22;
		TreeSubTreeOfAnotherDemo trees = new TreeSubTreeOfAnotherDemo();
		boolean isSubTree = trees.isSubTree(root1, root2);
		System.out.println(isSubTree);
	}

	private boolean isSubTree(Node root1, Node root2) {
		// Nothing to compare.
		if (root1 == null) {
			return false;
		}
		// null is subset of tree.
		if (root2 == null) {
			return true;
		}
		if (root1.data == root2.data) {
			return matchTree(root1, root2);

		}
		return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);

	}

	private boolean matchTree(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 == null || root2 == null)
			return false;

		if (root1.data != root2.data) {
			return false;
		}
		if (matchTree(root1.left, root2.left) && matchTree(root1.right, root2.right)) {
			return true;
		} else
			return false;

	}
}
