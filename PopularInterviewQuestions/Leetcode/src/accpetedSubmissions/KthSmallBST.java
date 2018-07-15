package accpetedSubmissions;

public class KthSmallBST {
	public static void main(String[] args) {
		// Ran on leetcode.
	}
	//Keep a global variable, if there is an ambiguity on when to return.
	int counter=0;
    public int kthSmallest(TreeNode root, int k) {       
        TreeNode result = traverseBST(root, k);
        return result.val;
    }
    
    public TreeNode traverseBST(TreeNode root, int k){
        if(root == null) return null;
        traverseBST(root.left,  k);
        counter+=1;
        if(counter == k) return root;
        traverseBST(root.right,  k);
        return null;
    }

}
