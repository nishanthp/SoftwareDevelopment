package PopularInProb;

import java.util.HashMap;

public class ZeroSumArray {
	int sum = 0;
	HashMap<Integer, Integer> sumMap = new HashMap<>();
	static int[] array = { 6, -2, 4, -3 };

	public static void main(String[] args) {
		ZeroSumArray z = new ZeroSumArray();
		System.out.println(z.zeroSumArray(array));
	}

	public Boolean zeroSumArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum == 0 || array[i] == 0 || sumMap.get(sum) != null) {
				return true;
			}
			sumMap.put(sum, i);
		}
		return false;
	}
}
