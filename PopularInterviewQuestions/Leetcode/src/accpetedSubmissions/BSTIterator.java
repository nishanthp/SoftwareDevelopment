package accpetedSubmissions;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// If they want in order, pointer should be poiting to the left most node. Look at constructor.
	TreeNode root = null;
    Deque<TreeNode> stack = new LinkedList<TreeNode>();
    public BSTIterator(TreeNode root) {
        this.root = root;
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty()) return false;
        else return true;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode currNode = stack.pop();
        System.out.println(currNode.val);
        if(currNode.right != null) {
            TreeNode rightNode = currNode.right;
            while(rightNode != null){
                stack.push(rightNode);
                rightNode = rightNode.left;
            }
        }
        return currNode.val;
        
    }

}
