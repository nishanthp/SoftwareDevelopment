package com.accpeted.submissions;

public class NextPermutation {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0) {
			int curr = nums[i];
			int next = nums[i + 1];
			if (curr < next) {
				break;
			}
			i--;
		}
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1, nums.length - 1);

	}
	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
	}
	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

}
