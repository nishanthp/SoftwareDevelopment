package com.accpeted.submissions;

import java.util.TreeSet;

public class Duplicate3 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer upper = set.ceiling(nums[i]);
			if (upper != null && upper <= nums[i] + t)
				return true;
			Integer lower = set.floor(nums[i]);
			if (lower != null && nums[i] <= lower + t)
				return true;
			set.add(nums[i]);
			if (set.size() > k) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}

}
