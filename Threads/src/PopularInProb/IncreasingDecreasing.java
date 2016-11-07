package PopularInProb;

public class IncreasingDecreasing {
	static int math_max = 0;

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 6, 45};
		findMxValue(input, 0);
		System.out.println(math_max);
	}

	private static int findMxValue(int[] input, int index) {
		if (index > input.length - 1) {
			return math_max;
		}
		if (input[index] > math_max) {
			math_max = input[index];
		}
		return findMxValue(input, ++index);
	}
}
