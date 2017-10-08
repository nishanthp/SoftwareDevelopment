package newSet;

import java.util.HashMap;
import java.util.Map.Entry;

public class MathEquationDemo {
	public static void main(String[] args) {
		int N = 9;
		int count = 0;
		for (Entry<Integer, Integer> entry : findPairs(N).entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
			count++;
		}
		System.out.println(count);
	}

	private static HashMap<Integer, Integer> findPairs(int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 1; i <= Math.cbrt(n); i++) {
			int tmp = n - i;
			double cubeRoot = Math.cbrt(tmp);
			if (Math.ceil(cubeRoot) == cubeRoot) {
				// if (a,b) and (b,a) is counted as seperate pairs.
				map.put((int) cubeRoot, i);
				map.put(i, (int) cubeRoot);
			}
		}
		return map;
	}

}
