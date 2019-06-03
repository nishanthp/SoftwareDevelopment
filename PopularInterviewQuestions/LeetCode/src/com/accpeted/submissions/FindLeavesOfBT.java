package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBT {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        findLeavesWithH(root);
        return result;
}
    
     public int findLeavesWithH(TreeNode root) {
         if(root == null) return -1;
         // this is important part. Get the height at each level.
         int currH = 1 + Math.max(findLeavesWithH(root.left), findLeavesWithH(root.right));
         List<Integer> temp;
         if(currH + 1 > result.size()) {
            result.add(new ArrayList<Integer>());
         } 
          temp = result.get(currH);
          temp.add(root.val);        
          return currH;         
     }

}
