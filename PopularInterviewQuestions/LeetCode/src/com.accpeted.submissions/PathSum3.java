package accpetedSubmissions;

import java.util.HashMap;

public class PathSum3 {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	
	 public int pathSum(TreeNode root, int sum) {
	        HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
	        return countPathSum(root, sum, 0, seen);
	    }
	    
	    public int countPathSum(TreeNode root, int sum, int runningSum, HashMap<Integer, Integer> seen) {
	        if(root == null) return 0;
	        runningSum += root.val;
	        int remainSum = runningSum - sum ; 
	        int totalPath = seen.getOrDefault(remainSum, 0);
	        if(runningSum == sum) totalPath +=1;
	        seen.put(runningSum, seen.getOrDefault(runningSum,0)+1);
	        totalPath += countPathSum(root.left,  sum,  runningSum, seen) +
	        countPathSum(root.right,  sum,  runningSum,  seen);
	        seen.put(runningSum, seen.get(runningSum)-1);
	        return totalPath;
	    }

}
