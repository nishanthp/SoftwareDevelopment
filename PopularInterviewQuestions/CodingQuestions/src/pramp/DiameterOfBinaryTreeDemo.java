package pramp;

public class DiameterOfBinaryTreeDemo {
	static int max = 0;

	public static void main(String[] args) {
		Node root = new Node(12);
		Node root1 = new Node(13);
		Node root2 = new Node(14);
		Node root3 = new Node(15);
		Node root4 = new Node(16);

		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;

		DiameterOfBinaryTreeDemo d = new DiameterOfBinaryTreeDemo();
		/*
		 * int diameter = d.findDiameterOfTree(root);
		 * System.out.println(diameter);
		 */
		d.HeightBTree(root);
		System.out.println(max);
	}

	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		int left = height(root.left);
		int right = height(root.right);
		return 1 + Math.max(left, right);
	}

	public int findDiameterOfTree(Node root) {
		if (root == null) {
			return 0;
		}

		int leftHeight = height(root.left);
		int rightHeight = height(root.right);

		int leftDia = findDiameterOfTree(root.left);
		int rightDia = findDiameterOfTree(root.right);

		return Math.max(leftHeight + rightHeight + 1, Math.max(leftDia, rightDia));
	}

	// Simpler way with just height.
	public int HeightBTree(Node root) {
		if (root == null) {
			return 0;
		}
		int left = HeightBTree(root.left);
		int right = HeightBTree(root.right);

		max = Math.max(max, left + right);

		return Math.max(left, right) + 1;

	}

}
