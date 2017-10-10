package pramp;

public class FindTargetValueORless {
	public static void main(String[] args) {
		Node root = new Node(20);
		Node root1 = new Node(9);
		Node root2 = new Node(25);
		Node root3 = new Node(5);
		Node root4 = new Node(18);
		// Node root5 = new Node(11);
		Node root6 = new Node(19);

		root.left = root1;
		root.right = root2;

		root1.left = root3;
		root1.right = root4;

		// root4.left = root5;
		root4.right = root6;

		int num = 10;
		int targetValue = 17;
		System.out.println(findTargetValue(root, num));
		System.out.println(findTargetVal(root, targetValue));
	}

	private static boolean findTargetValue(Node root, int targetValue) {
		Node current = root;
		while (current != null) {
			if (current.data == targetValue) {
				return true;
			} else if (current.data > targetValue) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return false;
	}

	// find largest value just less the target num.
	private static int findTargetVal(Node root, int targetValue) {
		int temp = -1;
		while (root != null) {
			if (root.data > targetValue) {
				root = root.left;
			} else {
				temp = root.data;
				root = root.right;
			}
		}
		return temp;
	}
}
