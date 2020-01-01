package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.List;

public class FindDuplicateInArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Interesting problem. Can be asked.
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0) {
				result.add(index + 1);
			} else {
				nums[index] = -nums[index];
			}
		}
		return result;
	}

}
