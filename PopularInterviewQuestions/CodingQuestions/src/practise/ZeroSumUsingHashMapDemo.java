package practise;

import java.util.HashMap;

public class ZeroSumUsingHashMapDemo {
	static HashMap<Integer, Integer> valueMap = new HashMap<>();

	public static void main(String[] args) {
		int[] input = { 1, 4, 3, 2, 2 };
		int sum = 7;
		findPairAddToSum(input, sum);
	}

	private static void findPairAddToSum(int[] input, int sum) {
		for (Integer i : input) {
			int temp = Math.abs(sum - i);
			if (valueMap.containsKey(temp)) {
				System.out.println("PAIR FOUND:" + temp + " " + valueMap.get(temp));
			}
			valueMap.put(i, temp);
		}
	}
}
