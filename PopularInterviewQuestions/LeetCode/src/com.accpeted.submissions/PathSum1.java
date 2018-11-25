package accpetedSubmissions;

public class PathSum1 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Does not require to store the path. No need of the array. use the
	// variable, it will take care of backtracking.
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
	}

}
