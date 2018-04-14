package AccpetedSubmissions;

public class MajorityElement {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int majorityElement(int[] nums) {
		if (nums.length == 0)
			return -1;
		int majorityElement = getMajorityElement(nums);
		if (majorityElement == -1)
			return -1;
		return validate(nums, majorityElement) ? majorityElement : -1;
	}

	public int getMajorityElement(int[] nums) {
		int count = 0;
		int majorityElement = -1;
		for (int num : nums) {
			if (count == 0) {
				majorityElement = num;
			}
			if (num == majorityElement) {
				count += 1;
			} else {
				count -= 1;
			}
		}

		return majorityElement;
	}

	public boolean validate(int[] nums, int majorityElement) {
		int count = 0;
		for (int num : nums) {
			if (num == majorityElement)
				count++;
		}

		return count >= (nums.length - 1) / 2 ? true : false;
	}

}
