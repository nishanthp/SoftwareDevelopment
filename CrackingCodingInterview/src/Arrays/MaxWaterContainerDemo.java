package Arrays;

public class MaxWaterContainerDemo {
	public static void main(String[] args) {
		int[] points = { 1, 2, 4, 2, 3, 2, 5, 2 };
		MaxWaterContainerDemo demo = new MaxWaterContainerDemo();
		int max = demo.maxWaterContainer(points);
		System.out.println(max);
	}

	public int maxWaterContainer(int[] points) {
		int left = 0;
		int right = points.length - 1;
		int max = 0;
		while (left < right) {
			max = Math.max(max, (right - left) * Math.min(points[left], points[right]));
			// Explore all possibilities with respect to left, only then
			// increment left.
			if (points[left] > points[right])
				right--;
			else
				left++;
		}
		return max;
	}
}
