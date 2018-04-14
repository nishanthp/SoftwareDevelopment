package AccpetedSubmissions;

import java.util.ArrayList;
import java.util.List;

public class BTRightSideView {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public List<Integer> rightSideView(TreeNode root) {
		ArrayList<Integer> rightElements = new ArrayList<Integer>();
		printRightView(root, 0, rightElements);
		return rightElements;
	}

	public void printRightView(TreeNode root, int index, ArrayList<Integer> rightElements) {
		if (root == null)
			return;
		if (rightElements.isEmpty() || index > (rightElements.size() - 1)) {
			rightElements.add(root.val);
		}
		index += 1;
		printRightView(root.right, index, rightElements);
		printRightView(root.left, index, rightElements);

	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
