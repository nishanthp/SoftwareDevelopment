package popularInProb;

import java.util.HashMap;

public class FindMinimumDifference {
	HashMap<Integer, NumberPairs> minMap = new HashMap<>();
	int minDiff = Integer.MAX_VALUE;
	static NumberPairs pairs = new NumberPairs();
	static int[] input = { 18, 5, 3, 19, 27, 25 };

	public static void main(String[] args) {
		FindMinimumDifference fmd = new FindMinimumDifference();
		fmd.findMinimumDiff(input, 0);
		System.out.println("N1\t" + pairs.num1 + "    N2\t" + pairs.num2);
	}

	public void findMinimumDiff(int[] input, int index) {
		if (index >= input.length - 1) {
			return;
		}

		for (int i = 0; i < input.length; i++) {
			if (index != i) {
				int difference = Math.abs(input[i] - input[index]);
				if (difference < minDiff) {
					pairs.num1 = input[i];
					pairs.num2 = input[index];
					minDiff = difference;
				}
			}
		}
		findMinimumDiff(input, index + 1);

	}
}

class NumberPairs {
	int num1;
	int num2;
}
