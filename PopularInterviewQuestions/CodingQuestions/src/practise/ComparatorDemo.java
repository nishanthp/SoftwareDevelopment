package practise;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class ComparatorDemo {
	public static void main(String[] args) {
		HashMap<Integer, Integer> unsort_hashmap = new HashMap<Integer, Integer>();
		unsort_hashmap.put(2, 3);
		unsort_hashmap.put(7, 5);
		unsort_hashmap.put(5, 7);
		unsort_hashmap.put(3, 4);
		unsort_hashmap.put(6, 0);

		TreeMap<Integer, Integer> sort_hashmap = new TreeMap<Integer, Integer>();
		sort_hashmap.putAll(unsort_hashmap);

		for (Entry<Integer, Integer> entry : sort_hashmap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}

	}
}

class HashMapComparator implements Comparator {

	HashMap<Integer, Integer> map;

	HashMapComparator(HashMap<Integer, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(Object o1, Object o2) {
		Comparable v1 = (Comparable) map.get(o1);
		Comparable v2 = (Comparable) map.get(o2);
		return v2.compareTo(v1);
	}

}
