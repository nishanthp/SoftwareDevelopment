package com.accpeted.submissions;

public class RemoveDuplicatesTwo {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int removeDuplicates(int[] nums) {
		int left = 1;
		int count = 1;
		for (int right = 1; right < nums.length; right++) {
			if (nums[right] == nums[right - 1]) {
				count += 1;
			} else {
				count = 1;
			}
			if (count <= 2) {
				nums[left++] = nums[right];
			}
		}
		return left;
	}

}
