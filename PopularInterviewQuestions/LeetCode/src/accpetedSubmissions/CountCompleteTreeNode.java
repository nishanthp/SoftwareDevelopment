package accpetedSubmissions;

public class CountCompleteTreeNode {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	int count =0;
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftD = leftDepth(root);
        int rightD = rightDepth(root);
        // important part is, calculate using the formula when you know it is complete for that level. No need to traverse. 
        // This will same time. A similar concept to memonization.
        if (leftD == rightD){
            return (1<<leftD) -1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    public int rightDepth(TreeNode root){
        int depth=0;
        while(root != null){
            depth +=1;
            root = root.right;
        }
        return depth;
    }
    
    public int leftDepth(TreeNode root){
        int depth=0;
        while(root != null){
            depth +=1;
            root = root.left;
        }
        return depth;
    }

}
