package accpetedSubmissions;

public class TrappingRainWater {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public int trap(int[] height) {
		if (height.length == 0)
			return 0;
		int i = 0;
		int j = height.length - 1;
		int lmax = height[0];
		int rmax = height[height.length - 1];
		int result = 0;

		while (i < j) {
			lmax = Math.max(lmax, height[i]);
			rmax = Math.max(rmax, height[j]);

			if (height[i] <= height[j])
				i++;
			else
				j--;

			if (lmax - height[i] > 0)
				result += lmax - height[i];
			if (rmax - height[j] > 0)
				result += rmax - height[j];
		}
		return result;
	}

}
