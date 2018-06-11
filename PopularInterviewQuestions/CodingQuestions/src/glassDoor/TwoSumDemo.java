package glassDoor;

import java.util.HashMap;
import java.util.Map.Entry;

public class TwoSumDemo {
	// This works if there are duplicates are not in the array.
	public static void main(String args[]) {
		int[] input = { 1, 1, 2, 4, 6, 7 };
		int sum = 13;
		twoSumInterface(input, sum);
	}

	private static void twoSumInterface(int[] input, int sum) {
		HashMap<Integer, Integer> count = new HashMap<>();

		for (int each : input) {
			if (count.containsKey(each)) {
				count.put(each, count.get(each) + 1);
			} else {
				count.put(each, 1);
			}

		}

		for (Entry<Integer, Integer> entry : count.entrySet()) {
			int remainingSum = sum - entry.getKey();
			if (count.containsKey(remainingSum) && count.get(remainingSum) > 0) {
				count.put(remainingSum, 0);
				count.put(entry.getKey(), 0);
				System.out.println("Key1:" + remainingSum + "Key2:" + entry.getKey());
			}
		}
	}
}
