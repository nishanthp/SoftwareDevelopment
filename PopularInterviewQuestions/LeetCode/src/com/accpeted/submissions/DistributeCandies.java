package com.accpeted.submissions;

import java.util.HashMap;
import java.util.Map;

public class DistributeCandies {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int distributeCandies(int[] candies) {
		Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
		int count = 0;
		for (int candy : candies) {
			count++;
			freq.put(candy, freq.getOrDefault(candy, 0) + 1);
		}

		int mid = count / 2;
		int sCount = 0;
		for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
			sCount += 1;
			if (sCount == mid)
				break;
		}
		return sCount;
	}

}
