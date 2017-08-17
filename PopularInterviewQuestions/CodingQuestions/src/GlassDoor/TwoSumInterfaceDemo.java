package GlassDoor;

import java.util.HashMap;

public class TwoSumInterfaceDemo {

}

interface TwoSum {
	public void store(int num);

	public boolean test();
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
	public boolean test() {
		return false;
	}

}
