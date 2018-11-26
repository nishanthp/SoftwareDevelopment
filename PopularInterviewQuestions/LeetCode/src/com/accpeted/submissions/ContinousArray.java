package com.accpeted.submissions;

import java.util.HashMap;

public class ContinousArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	// Count the number of 0s and 1s.
	public int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> countIndexMap = new HashMap<Integer, Integer>() {
			{
				// seems to be a general hack.
				put(0, -1);
			}
		};
		int count = 0;
		int maxLength = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				count -= 1;
			else
				count += 1;
			if (countIndexMap.containsKey(count)) {
				maxLength = Math.max(maxLength, i - countIndexMap.get(count));
			} else {
				countIndexMap.put(count, i);
			}
		}
		return maxLength;
	}

}
