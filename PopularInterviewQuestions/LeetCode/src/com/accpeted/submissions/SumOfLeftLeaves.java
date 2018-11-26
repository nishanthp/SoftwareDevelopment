package com.accpeted.submissions;

public class SumOfLeftLeaves {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Think of what it does at each level (Both recursion and iteration). 
	// No need to have level for this problem. 
	int totalSum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null) {
                totalSum += root.left.val;
            }else{
                sumOfLeftLeaves(root.left);
            }
        }      
        sumOfLeftLeaves(root.right);   
        return totalSum;
    }

}
