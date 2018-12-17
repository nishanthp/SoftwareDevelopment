package com.accpeted.submissions;

public class SortedArrToBST {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
        return createBT(nums, 0 , nums.length-1);
    }
    
    public TreeNode createBT(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = (left + right)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createBT(nums, left, mid-1);
        root.right = createBT(nums, mid+1, right);
        return root;
    }
    
    
    

}
