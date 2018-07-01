package accpetedSubmissions;

public class BinaryTreeTilt {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	int globalCount = 0;
    public int findTilt(TreeNode root) {
          findT(root); 
          return globalCount;
    }
    
    public int findT(TreeNode root){
        if(root == null) return 0;
        int leftVal = findT(root.left);
        int rightVal = findT(root.right);
        globalCount += Math.abs(leftVal - rightVal);
        return root.val + leftVal + rightVal;
    }

}
