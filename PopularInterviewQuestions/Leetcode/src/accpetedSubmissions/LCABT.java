package accpetedSubmissions;

public class LCABT {

	public static void main(String[] args) {
		// TODO Ran on leetcode.

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || p == null || q == null) return null;
        if(root.val == p.val || root.val == q.val) return root;
        boolean p_on_left = searchTree(root.left, p);
        boolean q_on_right = searchTree(root.left, q);
        if(p_on_left != q_on_right) return root;
        TreeNode parent_root = lowestCommonAncestor(root.left, p, q);
        if(parent_root != null) return parent_root;
        parent_root = lowestCommonAncestor(root.right, p, q);
        if(parent_root != null) return parent_root;
        return null;
    }
    
     public boolean searchTree(TreeNode root, TreeNode p){
        if(root == null) return false;
        if(root.val == p.val) return true;
        return searchTree(root.left,  p) || searchTree(root.right,  p);
    }

}
