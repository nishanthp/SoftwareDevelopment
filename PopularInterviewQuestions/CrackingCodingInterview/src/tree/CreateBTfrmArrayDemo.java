package Tree;

public class CreateBTfrmArrayDemo {
	static int[] input = { 1, 2, 3, 4, 5, 6, 7 };

	public static void main(String[] args) {
		CreateBTfrmArrayDemo btree = new CreateBTfrmArrayDemo();
		Node root = btree.createBT(input, 0, input.length - 1);

		// print tree.
		System.out.println(root.right.left.data);
	}

	public Node createBT(int[] input, int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		Node root = new Node(input[mid]);
		root.left = createBT(input, start, mid - 1);
		root.right = createBT(input, mid + 1, end);
		return root;
	}
}
