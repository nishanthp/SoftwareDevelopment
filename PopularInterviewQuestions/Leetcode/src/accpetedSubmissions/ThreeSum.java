package AccpetedSubmissions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	/**
	 * Works on duplicates on input array. Returns all unique pairs, not just
	 * one.
	 * 
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new LinkedList<List<Integer>>();
		if (nums.length < 3)
			return lists;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			// Concentrate on the below 3 statements.
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			if (nums[i] * 3 > 0)
				break;
			if (nums[i] + 2 * nums[nums.length - 1] < 0)
				continue;

			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == 0) {
					lists.add(new LinkedList<Integer>(Arrays.asList(nums[i], nums[start], nums[end])));
					while (start < end && nums[start] == nums[start + 1])
						start++;
					while (start < end && nums[end] == nums[end - 1])
						end--;
					start++;
					end--;
				} else if (sum < 0)
					start++;
				else
					end--;
			}
		}
		return lists;
	}
}
