package GlassDoor;

public class MinimumSizeSubarray {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 5, 8, 7, 6, 9, 5, 7, 3, 0, 5, 2, 3, 4, 4, 7 };
		int[] sub = { 5, 7 };
		findMinimumSizeSubarray(nums, sub);
	}

	private static void findMinimumSizeSubarray(int[] nums, int[] sub) {
		for (int i = 0; i < nums.length;) {
			while (nums[i] == sub[0]) {
				i++;
			}
			
		}

	}
}

