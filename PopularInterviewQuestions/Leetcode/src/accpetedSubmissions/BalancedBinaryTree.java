package AccpetedSubmissions;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isBalanced(TreeNode root) {
		return height(root) == -1 ? false : true;
	}

	public int height(TreeNode root) {
		if (root == null)
			return 0;
		int left = height(root.left);
		if (left == -1)
			return -1;
		int right = height(root.right);
		if (right == -1)
			return -1;
		if (Math.abs(left - right) > 1)
			return -1;
		return 1 + Math.max(left, right);
	}
}
