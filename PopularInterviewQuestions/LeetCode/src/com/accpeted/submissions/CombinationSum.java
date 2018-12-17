package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// backtracking example for an array. recursion for every element in the array. So recurssion within a for loop.
	//O(n+k)! I dont know how??
	List<List<Integer>> lists = new LinkedList<>();
    List<Integer> list = new LinkedList<Integer>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {      
        combinationSum(candidates, target, 0 );
        return lists;
    }
    
     public void combinationSum (int[] input, int remainingSum, int start){
         if(remainingSum < 0) return;
         if (remainingSum == 0) {
             List<Integer> tempList = new LinkedList<Integer>();
             tempList.addAll(list);
             lists.add(tempList);
             return;
         }

         for(int i=start; i<input.length; i++){    
            list.add(input[i]);
            combinationSum(input,remainingSum-input[i], i);
            list.remove(list.size()-1);
         }
     }

}
