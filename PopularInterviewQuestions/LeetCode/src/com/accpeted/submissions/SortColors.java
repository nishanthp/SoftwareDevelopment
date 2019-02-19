package com.accpeted.submissions;

public class SortColors {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public void sortColors(int[] nums) {
        int left = 0;
        int mid = 0;
        int right = nums.length-1;
        while(mid <= right) {
            switch (nums[mid]){
            case 0:
              int temp = nums[left];
              nums[left++] = nums[mid];
              nums[mid++] = temp;
              break;
            case 1:
                // do nothing.
                    mid++;
                    break;
            case 2:
              temp = nums[right];
              nums[right--] = nums[mid];
              nums[mid] = temp;
              break;
        }
        }
    }

}
