package com.accpeted.submissions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubSets {

	public static void main(String[] args) {
		// Ran on leetcode.
		int [] nums = {1,3,5};
		SubSets s = new SubSets();
		s.subsetsWithDup(nums);

	}
	// Works for both duplicates and non duplicates.
	List<List<Integer>> lists = new LinkedList<>();
    List<Integer> list = new LinkedList<Integer>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subSets(nums, 0);
        return lists;
    }
    
    public void subSets(int [] nums, int start){
        if(list.size() > nums.length) return;
        if(!lists.contains(list)){
            List<Integer> tempList = new LinkedList<Integer>();
            tempList.addAll(list);
            lists.add(tempList);
        }
        for(int i=start; i< nums.length; i++){
            list.add(nums[i]);
            printList(list);
            subSets(nums, i+1);
            list.remove(list.size()-1);
        }
    }

	private void printList(List<Integer> list2) {
		for(Integer n : list2){
			System.out.print(n);
		}
		System.out.println();
		
	}

}
