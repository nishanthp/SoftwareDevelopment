package accpetedSubmissions;

public class FindPivotIndex {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int pivotIndex(int[] nums) {
		if (nums.length <= 2)
			return -1;
		int[] leftSum = new int[nums.length];
		int[] rightSum = new int[nums.length];
		leftSum[0] = 0;
		rightSum[nums.length - 1] = 0;

		// fill up leftSum
		for (int i = 1; i <= nums.length - 1; i++) {
			leftSum[i] = leftSum[i - 1] + nums[i - 1];
		}
		// fill up rightSum
		for (int i = nums.length - 2; i >= 0; i--) {
			rightSum[i] = nums[i + 1] + rightSum[i + 1];
		}

		// check the stored values.
		for (int i = 0; i <= nums.length - 1; i++) {
			if (leftSum[i] == rightSum[i])
				return i;
		}
		return -1;
	}
}
