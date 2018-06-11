package accpetedSubmissions;

public class DeleteNode {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return null;
		if (root.val < key)
			root.right = deleteNode(root.right, key);
		else if (root.val > key)
			root.left = deleteNode(root.left, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			else {
				TreeNode rightRoot = root.right;
				while (rightRoot.left != null)
					rightRoot = rightRoot.left;
				rightRoot.left = root.left;
				return root.right;
			}
		}
		return root;
	}
}
