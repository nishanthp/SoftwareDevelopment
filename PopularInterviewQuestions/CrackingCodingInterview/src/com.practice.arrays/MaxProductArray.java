package arrays;

public class MaxProductArray {
	int input[] = { 6, -3, -10, 0, 2 };

	public static void main(String[] args) {
		MaxProductArray product = new MaxProductArray();
		int sum = product.maxProductSum();
		System.out.println(sum);
	}

	public int maxProductSum() {
		int min_ending_here = 1;
		int max_ending_here = 1;
		int max_so_far = 1;

		for (int i = 0; i < input.length; i++) {
			if (input[i] == 0) {
				min_ending_here = 1;
				max_ending_here = 1;
			} else if (input[i] > 0) {
				max_ending_here = max_ending_here * input[i];
				min_ending_here = min(min_ending_here * input[i], 1);
			} else {
				int temp = max_ending_here;
				max_ending_here = max(min_ending_here * input[i], 1);
				min_ending_here = temp * input[i];
			}

			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
			}

		}
		return max_so_far;
	}

	public int min(int x, int y) {
		return x < y ? x : y;
	}

	public int max(int x, int y) {
		return x > y ? x : y;
	}
}
