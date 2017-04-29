package PopularInProb;

public class RigthViewOfBinaryTree {
	public static void main(String[] args) {
		BTree root = new BTree(7);
		BTree root_1 = new BTree(2);
		BTree root_2 = new BTree(1);
		BTree root_3 = new BTree(3);
		BTree root_4 = new BTree(6);
		BTree root_5 = new BTree(9);
		BTree root_6 = new BTree(11);
		BTree root_7 = new BTree(10);
		BTree root_8 = new BTree(12);
		root.left = root_1;
		root.right = root_4;
		root_1.left = root_3;
		root_1.right = root_2;
		root_4.left = root_5;
		root_4.right = root_6;
		root_6.left = root_7;
		root_6.right = root_8;

		RigthViewOfBinaryTree bt = new RigthViewOfBinaryTree();
		// bt.printRightVoew(root);
		bt.printLeftVoew(root);
	}

	public void printRightVoew(BTree root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printRightVoew(root.right);
	}

	public void printLeftVoew(BTree root) {
		if (root == null) {
			return;
		}
		System.out.println(root.data);
		printLeftVoew(root.left);
	}
}

class BTree {
	int data;
	BTree left;
	BTree right;

	public BTree(int d) {
		this.data = d;
	}
}
