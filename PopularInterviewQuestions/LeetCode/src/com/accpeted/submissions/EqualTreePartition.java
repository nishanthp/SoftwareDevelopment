package com.accpeted.submissions;

import java.util.HashMap;

public class EqualTreePartition {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    int runningSum = 0;
    public boolean checkEqualTree(TreeNode root) {
        checkEqualTree1(root);
        // This is the important part. Corner case [-1, 0, 1] (0 is the root node).
        if(runningSum == 0) return map.getOrDefault(runningSum, 0) > 1;
        return (runningSum % 2 == 0 && map.getOrDefault(runningSum/2, 0) != 0);
    }
    
    public int checkEqualTree1(TreeNode root) {
        if(root == null) return 0;
        runningSum = root.val + checkEqualTree1(root.left) + checkEqualTree1(root.right);
        map.put(runningSum, map.getOrDefault(runningSum, 0)+1);  
        return runningSum;
    }

}
