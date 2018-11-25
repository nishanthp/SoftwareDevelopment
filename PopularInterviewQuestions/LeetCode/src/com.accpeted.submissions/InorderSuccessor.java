package accpetedSubmissions;

public class InorderSuccessor {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while(root != null){
            if(root.val > p.val){
                succ = root;
                root = root.left;
            }else root = root.right;
        }
        return succ;
    }

}
