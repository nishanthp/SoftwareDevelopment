package accpetedSubmissions;

public class ValidateBST {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean isValidBST(TreeNode root) {
		return isValid(root, 0, 0);
	}

	public boolean isValid(TreeNode root, int max, int min) {
		if (root == null)
			return true;
		if (min != 0 && root.val <= min || max != 0 && root.val >= max)
			return false;
		if (root.left != null && root.left.val >= root.val || root.right != null && root.right.val <= root.val)
			return false;
		return isValid(root.left, root.val, min) && isValid(root.right, max, root.val);
	}
}
