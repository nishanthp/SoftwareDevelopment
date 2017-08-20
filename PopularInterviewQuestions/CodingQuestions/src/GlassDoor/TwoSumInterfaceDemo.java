package GlassDoor;

import java.net.Socket;
import java.util.HashMap;
import java.util.Map.Entry;

public class TwoSumInterfaceDemo {
	public static void main(String[] args) {
		TwoSum s = new Solution();
		s.store(1);
		s.store(4);
		s.store(2);
		System.out.println(s.test(3));
	}
}

interface TwoSum {
	public void store(int num);

	public boolean test(int num);
}

class Solution implements TwoSum {
	HashMap<Integer, Integer> map = new HashMap<>();

	@Override
	public void store(int num) {
		if (map.containsKey(num)) {
			map.put(num, map.get(num) + 1);
		} else {
			map.put(num, 1);
		}
	}

	@Override
	public boolean test(int num) {
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			int temp = num - entry.getKey();
			// false positives
			if (entry.getValue() > 1) {
				if (compareAllPossibleValues(entry, num)) {
					return true;
				}
			}

			if (map.containsKey(temp)) {
				return true;
			}
		}
		return false;
	}

	private boolean compareAllPossibleValues(Entry<Integer, Integer> entry, int num) {
		int key = entry.getKey();
		int occurance = entry.getValue();
		while (occurance > 1) {
			if (key * occurance == num) {
				return true;
			}
			occurance--;
		}
		return false;

	}

}
