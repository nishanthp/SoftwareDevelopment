package popularInProb;

public class IncreasingDecreasing {
	static int math_max = 0;

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 6, 45 };
		findMxValue(input, 0);
		System.out.println(math_max);

		int i = findMxValuendex(input, 0);
		System.out.println(i);
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

	private static int findMxValuendex(int[] input, int index) {
		math_max = input[index];
		for (int i = 1; i < input.length; i++) {
			if (input[i] < math_max) {
				return i - 1;
			}else
			{
				math_max = input[i];
			}
			index = i;
		}
		return index;
	}
}
