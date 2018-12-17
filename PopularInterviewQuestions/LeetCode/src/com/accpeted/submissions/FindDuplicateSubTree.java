package com.accpeted.submissions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FindDuplicateSubTree {
	HashMap<String, Integer> map = new HashMap<String, Integer>();
    List<TreeNode> list = new LinkedList<TreeNode>();
	public static void main(String[] args) {
		// Ran on leetcode.
		
	}

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        checkDuplicate(root);
        return list;
    }
    
    public String checkDuplicate(TreeNode root){
        if(root == null) return "#";
        String serial = String.valueOf(root.val) + "," + checkDuplicate(root.left) + checkDuplicate(root.right);
        if(map.getOrDefault(serial, 0) == 1) list.add(root);
        // this should not be else as we want to count 1 or more duplicate tree, however add only one to the list. 
        // Set will not work as we treeNode class has not overridden .equals methods to compare two treeNode objects.
        map.put(serial, map.getOrDefault(serial, 0) + 1);
        return serial;
    }
}

