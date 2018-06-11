package msft;

import java.util.HashMap;

public class HashMapDataStruct {
	public static void main(String[] args) {
		HashMapStruct struct = new HashMapStruct();
		struct.set(1, 2);
		struct.set(2, 5);
		struct.set(3, 6);
		struct.set(4, 8);
		// struct.setAll(134);

		System.out.println(struct.get(1));
	}
}

// ds which supports get(int), set(int), setAll(int) in constant time.
class HashMapStruct {
	private int globalValue = Integer.MAX_VALUE;
	private HashMap<Integer, Integer> map = new HashMap<>();

	public int get(int key) {
		if (map.containsKey(key)) {
			return map.get(key);
		} else if (globalValue != Integer.MAX_VALUE) {
			return globalValue;
		} else {
			return -1;
		}
	}

	public void setAll(int value) {
		map = new HashMap<>();
		globalValue = value;
	}

	public void set(int key, int value) {
		if (map.containsKey(key)) {
			int oldvalue = map.get(key);
			map.put(key, value);
		} else {
			map.put(key, value);
		}
	}
}
