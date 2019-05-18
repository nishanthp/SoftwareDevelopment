package com.revision.nthTime;

import java.util.LinkedList;
import java.util.List;

public class Subset {

	static List<List<Integer>> lists = new LinkedList<>();
	public static void main(String[] args) {
		int[] nums = {1,3,5};
		generateAllSubsets(nums,new LinkedList<Integer>(), 0);
		for(List<Integer> list : lists) {
			for(int each : list) {
				System.out.print(each);
			}
			System.out.println();
		}
	}
	
	// topdown approach 1.
	// Time complexity - O(2^n)
	// Space complexity - O(1)
	public static void generateAllSubsets(int[] nums, List<Integer> curr, int index) {
		if(index >= nums.length) {
			List<Integer> temp = new LinkedList<Integer>();
			temp.addAll(curr);
			lists.add(temp);
			//temp.clear();
			return;
		}
		// include the current number pointed by index.
		curr.add(nums[index]);
		generateAllSubsets(nums, curr, index+1);
		curr.remove(curr.size()-1);
		// exclude the current number pointed by index.
		generateAllSubsets(nums, curr, index+1);
	}
	
}
