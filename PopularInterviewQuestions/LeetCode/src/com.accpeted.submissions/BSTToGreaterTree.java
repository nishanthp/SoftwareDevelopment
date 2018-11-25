package accpetedSubmissions;

public class BSTToGreaterTree {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	// keeping a global variable is key, if keeping a variable passing through recurssion is not working.
	int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }

}
