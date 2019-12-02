package com.accpeted.submissions;

public class RemoveDuplicatesInPlace {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int removeDuplicates(int[] nums) {
		// if(nums.length == 0) return 0;
		// if(nums.length == 1) return 1;
		// int count = 0;
		// int left = 0;
		// int right = left+1;
		// while(right < nums.length){
		// while(right < nums.length && nums[left] == nums[right]) right +=1;
		// if(right < nums.length) nums[++left] = nums[right];
		// count+=1;
		// }
		// return count;

		int left = 0;
		for (int right = 0; right < nums.length; right++) {
			if (right == 0 || nums[right] != nums[right - 1])
				nums[left++] = nums[right];
		}
		return left;
	}

}
