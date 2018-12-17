package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class PathSumTwo {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	List<List<Integer>> paths = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        addPath(root, sum, new LinkedList<Integer>());    
        return paths;
    }
    
    public void addPath(TreeNode root, int sum, List<Integer> path){
        if(root == null) return;  
        path.add(root.val);
        sum -= root.val;
        if(root.left == null && root.right == null && sum == 0){
            //if (paths.contains(path)) return;
            List<Integer> temp = new LinkedList<Integer>();
            temp.addAll(path);
            paths.add(temp);
            path.remove(path.size()-1);
            return;
        }   
        addPath(root.left, sum, path);
        addPath(root.right, sum, path);
        path.remove(path.size()-1);
}

}
