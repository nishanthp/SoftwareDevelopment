package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {

	public static void main(String[] args) {	
		//Ran on leetcode.
}
	
	List<List<Integer>> lists = new LinkedList<>();
    List<Integer> list = new LinkedList<Integer>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //You need to sort them to compare the lists when you add them to lists. 
    	Arrays.sort(candidates);
        combinationSum(candidates, target, 0 );
        return lists;
    }
    
     public void combinationSum (int[] input, int remainingSum, int start){
         if(remainingSum < 0) return;
         // Contains complexity, O(n*n) if there are n entries in lists and each list has n entries.
         if (remainingSum == 0 && !lists.contains(list)) {
             List<Integer> tempList = new LinkedList<Integer>();
             tempList.addAll(list);
             lists.add(tempList);
             return;
         }

         for(int i=start; i<input.length; i++){    
            list.add(input[i]);
            combinationSum(input,remainingSum-input[i], i+1);
            list.remove(list.size()-1);
         }
     }
}
