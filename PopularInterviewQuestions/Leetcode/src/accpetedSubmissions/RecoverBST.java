package accpetedSubmissions;

import java.util.Stack;

public class RecoverBST {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	//Keeping global references is the key. 
	//if Inorder think of putting it in an array. It will be sorted. Now that two elements are not in place, compare the previous element 
	// with the current element.
	TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        recoverT(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }
    
    public void recoverT(TreeNode root){
        if(root ==null) return;
        recoverT(root.left);
        if(firstElement == null && prevElement.val > root.val) firstElement = prevElement;
        if(firstElement != null && prevElement.val > root.val) secondElement = root;
        prevElement = root;
        recoverT(root.right);
    }

}
