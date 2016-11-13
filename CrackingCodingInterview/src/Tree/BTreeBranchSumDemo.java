package Tree;

import java.util.ArrayList;

public class BTreeBranchSumDemo {

	public static void main(String[] args) {
		int sum = 14;
		Node root = new Node(10);
		Node root1 = new Node(8);
		Node root2 = new Node(7);
		Node root3 = new Node(6);
		Node root4 = new Node(3);
		Node root5 = new Node(2);
		root.left = root1;
		root.right = root4;
		root1.left = root2;
		root1.right = root3;
		root4.left = root5;
		int value = findDepth(root);
		int[] sumPath = new int[value];
		BTreeBranchSumDemo sumBranch = new BTreeBranchSumDemo();
		sumBranch.findSum(root, sum, 0, sumPath);
	}

	private static int findDepth(Node root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(findDepth(root.left), findDepth(root.right));

	}

	/* Having level is the tricky part for replacing the elements and using an
	 array instead of an arrayList as the arraylist will not replace the
	 elements at a particular index.*/
	private void findSum(Node root, int sum, int level, int[] sumPath) {
		if (root == null) {
			return;
		}
		sumPath[level] = root.data;
		int actualSum = 0;
		for (int i = level; i >= 0; i--) {
			actualSum += sumPath[i];
			if (actualSum == sum) {
				printPath(i, level, sumPath);
			}

		}
		findSum(root.left, sum, level + 1, sumPath);
		findSum(root.right, sum, level + 1, sumPath);

	}

	private void printPath(int start, int end, int[] sumPath) {
		for (int index = start; index <= end; index++) {
			System.out.println(sumPath[index]);
		}

	}
}
