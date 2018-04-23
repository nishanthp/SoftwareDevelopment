package AccpetedSubmissions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	/**
	 * Works on duplicate elements too. Returns all unique pairs, not just one.
	 */
	public List<List<Integer>> fourSum(int[] nums, int target) {
		// Sort the input array.
		Arrays.sort(nums);
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if (nums.length < 4)
			return lists;
		for (int i = 0; i < nums.length - 3; i++) {
			// Concentrate on the below 2 statements.
			if (nums[i] * 4 > target)
				break; // this is too big for the target.
			if (nums[i] + nums[nums.length - 1] * 3 < target)
				continue; // the range of numbers in the array is too small.
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (nums[j] * 3 > target - nums[i])
					break; // this is too big for the target.
				if (nums[j] + nums[nums.length - 1] * 2 < target - nums[i])
					continue; // the range of numbers in the array is too small.
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;
				int start = j + 1;
				int end = nums.length - 1;
				while (start < end) {
					int sum = nums[i] + nums[j] + nums[start] + nums[end];
					if (sum == target) {
						lists.add(new LinkedList<Integer>(Arrays.asList(nums[i], nums[j], nums[start], nums[end])));
						while (start < end && nums[end] == nums[end - 1])
							end--;
						while (start < end && nums[start] == nums[start + 1])
							start++;
						start++;
						end--;
					} else if (sum > target)
						end--;
					else
						start++;
				}
			}
		}
		return lists;
	}
}
