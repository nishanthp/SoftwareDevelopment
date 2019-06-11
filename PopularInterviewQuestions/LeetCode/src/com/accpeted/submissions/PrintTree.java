package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintTree {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	List<List<String>> result = new LinkedList<>();
    public List<List<String>> printTree(TreeNode root) {
        int totalRows = getHeight(root);
        System.out.println(totalRows);
        int totalCols = (int) Math.pow(2, totalRows)-1;
        System.out.println(totalCols);
        for(int i = 0; i<totalRows; i++){
            List<String> temp = new ArrayList<String>();
            for(int j=0;j<totalCols;j++){
                temp.add("");
            }
            result.add(temp);
        }
        printTree(root, 0, totalRows, totalCols, 0, totalCols);
        return result;
    }
    
    public void printTree(TreeNode root, int curRow, int totalRows, int totalCols, int left, int right) {
       if(root == null || curRow >= totalRows) return;
        int mid  = (left+right)/2;
        result.get(curRow).set(mid, String.valueOf(root.val));
        printTree(root.left, curRow+1, totalRows, totalCols, left, mid-1);
        printTree(root.right, curRow+1, totalRows, totalCols, mid+1, right);
        return;
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1+ Math.max(getHeight(root.left), getHeight(root.right));
    }

}
