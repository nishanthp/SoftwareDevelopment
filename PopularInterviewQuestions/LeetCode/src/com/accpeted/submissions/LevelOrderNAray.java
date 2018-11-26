package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class LevelOrderNAray {

	public static void main(String[] args) {
		// TODO Ran on leetcode.

	}
	List<List<Integer>> lists = new LinkedList<>();
    public List<List<Integer>> levelOrder(Node root) {
        levelOrder(root, 0);
        return lists;
    }
    
    public void levelOrder(Node root, int level){
        if(root == null) return;
        List<Integer> list;  
        if(lists.size() > level){
            list = lists.get(level);
            list.add(root.val);
            lists.set(level, list);
        }else{
            list = new LinkedList<Integer>();
            list.add(root.val);
            lists.add(list);
        }  
        for(Node child : root.children){
            levelOrder(child, level+1);
        }
    } 

}
