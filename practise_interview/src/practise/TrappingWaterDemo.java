package practise;
/*
 * calculate the result - Water trapped is calculated at every element.
 * So at every element we need to know the max height of the bars on
 * both sides. Take the min of those two bars and subtract that with the
 * height of bar at the element.
 */
public class TrappingWaterDemo {
	public static void main(String[] args) {
		int[] waterbar = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int trappedWater = amountofWaterTrapped(waterbar);
		System.out.println(trappedWater);
	}

	private static int amountofWaterTrapped(int[] waterbar) {
		int[] left = new int[waterbar.length];
		int[] right = new int[waterbar.length];

		// find maxRight and maxLeft.
		left[0] = waterbar[0];
		int maxLeft = waterbar[0];
		for (int i = 1; i < waterbar.length; i++) {
			if (waterbar[i] < maxLeft) {
				left[i] = maxLeft;
			} else {
				left[i] = waterbar[i];
				maxLeft = waterbar[i];
			}
		}

		right[right.length - 1] = waterbar[waterbar.length - 1];
		int maxRight = waterbar[waterbar.length - 1];
		for (int i = right.length - 2; i >= 0; i--) {
			if (waterbar[i] < maxRight) {
				right[i] = maxRight;
			} else {
				right[i] = waterbar[i];
				maxRight = waterbar[i];
			}
		}

		
		int result = 0;
		for (int i = 0; i < waterbar.length; i++) {
			result += Math.min(left[i], right[i]) - waterbar[i];
		}
		return result;
	}

}
