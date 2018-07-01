package accpetedSubmissions;

public class HouseRobber {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int rob(TreeNode root) {
        int [] sums = robTree(root);
        return Math.max(sums[0], sums[1]);
    }
    
    public int[] robTree(TreeNode root){
        if(root == null) return new int[]{0,0};      
        int []maxValue = new int[2];
        int []left = robTree(root.left);
        int []right = robTree(root.right);
        maxValue[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        maxValue[1] = root.val + left[0] + right[0];
        return maxValue;
    }
}
