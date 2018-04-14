package AccpetedSubmissions;

public class SearchInRotatedArray {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	// Without recursion.
	public int searchWithoutRecursion(int[] nums, int target) {
		// if (nums.length == 0) return -1;
		// return search(nums, target, 0, nums.length-1);

		int left = 0;
		int right = nums.length - 1;
		int length = nums.length;
		// Find the lowest element in the array.
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[right])
				left = mid + 1;
			else
				right = mid;
		}
		// left and right will point at the lowest number, which will tell how
		// much the array is rotated by.
		int rotateIndex = left;
		left = 0;
		right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int actualMid = (mid + rotateIndex) % length;
			if (nums[actualMid] == target)
				return actualMid;
			if (target < nums[actualMid])
				right = mid - 1;
			else
				left = mid + 1;
		}

		return -1;
	}

	// With recursion.
	public int search(int[] nums, int target) {
		if (nums.length == 0)
			return -1;
		return search(nums, target, 0, nums.length - 1);
	}

	public int search(int[] nums, int target, int left, int right) {
		int mid = (left + right) / 2;
		if (nums[mid] == target)
			return mid;
		// check the sorted part first, as binary search works only on sorted
		// array.
		if (left < right) {
			if (nums[mid] > nums[left]) {
				// check if target num in range.
				if (target >= nums[left] && target <= nums[mid - 1]) {
					return search(nums, target, left, mid - 1);
				} else {
					return search(nums, target, mid + 1, right);
				}
			}
			// all the other cases.
			if (target >= nums[mid + 1] && target <= nums[right]) {
				return search(nums, target, mid + 1, right);
			} else {
				return search(nums, target, left, mid - 1);
			}
		}
		return -1;
	}
}
