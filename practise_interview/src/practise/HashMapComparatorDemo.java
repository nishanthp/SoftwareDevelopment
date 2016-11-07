package practise;

import java.util.Comparator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class HashMapComparatorDemo implements Comparator<Integer> {
	static TreeMap<Integer, Integer> map = new TreeMap<>();

	public HashMapComparatorDemo(TreeMap<Integer, Integer> reqMap) {
		this.map = reqMap;
	}

	@Override
	public int compare(Integer o1, Integer o2) {
		return this.map.get(o2).compareTo(this.map.get(o1));

	}

	public static void main(String[] args) {
		HashMapComparatorDemo hcd = new HashMapComparatorDemo(new TreeMap<Integer, Integer>());
		map.put(1, 10);
		map.put(2, 9);
		map.put(4, 8);
		map.put(3, 4);
		map.put(7, 6);
		map.put(5, 5);
		TreeMap<Integer, Integer> soretedMap = new TreeMap<>(hcd);
		soretedMap.putAll(map);
		for (Entry<Integer, Integer> entry : soretedMap.entrySet()) {
			System.out.println("KEY:" + entry.getKey() + "VALUE:" + entry.getValue());

		}

	}

}
