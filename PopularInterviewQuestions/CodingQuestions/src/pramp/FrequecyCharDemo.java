package pramp;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FrequecyCharDemo {

	public static void main(String[] args) {
		String input = "abccc";
		int k = 1;
		HashMap<String, Integer> hash = new HashMap<>();
		for (Character c : input.toCharArray()) {
			if (hash.containsKey(c.toString())) {
				hash.put(c.toString(), hash.get(c.toString()) + 1);
			} else {
				hash.put(c.toString(), 1);
			}
		}
		TreeMap<String, Integer> map = new TreeMap<String, Integer>(new Compar(hash));
		map.putAll(hash);
		map = removeElements(map, k);
		int val = 0;
		for (Integer value : map.values()) {
			if (value == 0)
				continue;
			val += Math.pow(value, value);
		}
		System.out.println(val);
	}

	private static TreeMap<String, Integer> removeElements(TreeMap<String, Integer> map, int k) {
		if (map.isEmpty()) {
			return null;
		}
		if (k == 0) {
			return map;
		}
		Entry<String, Integer> entry = map.firstEntry();
		if (entry.getValue() == 0 && k == 0) {
			map.remove(entry.getKey());
			return map;
		} else if (k != 0) {
			map.put(entry.getKey(), entry.getValue() - 1);
			removeElements(map, k - 1);
		}
		return map;
	}
}

class Compar implements Comparator<String> {
	HashMap<String, Integer> inside = new HashMap<String, Integer>();

	public Compar(HashMap<String, Integer> m) {
		this.inside = m;
	}

	@Override
	public int compare(String o1, String o2) {
		if (this.inside.get(o1).equals(this.inside.get(o2))) {
			return o1.compareTo(o2);
		}
		return this.inside.get(o2).compareTo(this.inside.get(o1));
	}
}