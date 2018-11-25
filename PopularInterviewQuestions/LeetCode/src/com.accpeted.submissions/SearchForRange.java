package accpetedSubmissions;

public class SearchForRange {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public int[] searchRange(int[] nums, int target) {
		int[] indexVal = new int[] { -1, -1 };
		return findElement(0, nums.length - 1, indexVal, nums, target);
	}

	public int[] findElement(int left, int right, int[] indexValues, int[] nums, int target) {
		int mid = (left + right) / 2;
		if (mid < left || mid > right)
			return indexValues;
		if (nums[mid] == target) {
			if (indexValues[0] == -1) {
				indexValues[0] = mid;
				indexValues[1] = mid;
			} else {
				indexValues[0] = Math.min(indexValues[0], mid);
				indexValues[1] = Math.max(indexValues[1], mid);
			}
			indexValues = findElement(left, mid - 1, indexValues, nums, target);
			indexValues = findElement(mid + 1, right, indexValues, nums, target);
		} else if (nums[mid] > target) {
			indexValues = findElement(left, mid - 1, indexValues, nums, target);
			return indexValues;

		} else if (nums[mid] < target) {
			indexValues = findElement(mid + 1, right, indexValues, nums, target);
			return indexValues;

		}
		return indexValues;
	}
}
