package PopularInProb;

public class InvertBinaryTree {
	public static void main(String[] args) {
		InvertNod root = new InvertNod(4);
		InvertNod root_1 = new InvertNod(3);
		InvertNod root_2 = new InvertNod(2);
		InvertNod root_3 = new InvertNod(1);
		InvertNod root_4 = new InvertNod(6);
		InvertNod root_5 = new InvertNod(7);

		root.left = root_1;
		root.right = root_2;
		root_1.left = root_3;
		root_1.right = root_4;
		root_2.right = root_5;

		InvertBinaryTree ibt = new InvertBinaryTree();
		ibt.invertBinaryTree(root);
		System.out.println(root.left.left.d);
	}

	public void invertBinaryTree(InvertNod root) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		InvertNod temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
	}
}

class InvertNod {
	int d;
	InvertNod left;
	InvertNod right;

	public InvertNod(int data) {
		this.d = data;
	}

}
