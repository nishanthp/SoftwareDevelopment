package newSet;

import java.util.HashMap;
import java.util.Map.Entry;

public class FlattenDictDemo {
	public static void main(String[] args) {

		HashMap<String, Object> dict2 = new HashMap<>();
		dict2.put("d", "3");
		dict2.put("e", "2");

		HashMap<String, Object> dict1 = new HashMap<>();
		dict1.put("a", "2");
		dict1.put("b", "3");
		dict1.put("c", dict2);

		HashMap<String, Object> dict = new HashMap<>();
		dict.put("key1", "1");
		dict.put("Key2", dict1);

		HashMap<String, Object> flatten_dict = new HashMap<>();
		FlattenDictDemo d = new FlattenDictDemo();
		d.flattenDict(dict, "", flatten_dict);

		for (Entry<String, Object> entry : flatten_dict.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

	public void flattenDict(HashMap<String, Object> dict, String key, HashMap<String, Object> flatten_dict) {
		for (Entry<String, Object> entry : dict.entrySet()) {
			if (entry.getValue() instanceof String) {
				flatten_dict.put(key + entry.getKey(), entry.getValue());
			} else if (entry.getValue() instanceof Object) {
				flattenDict((HashMap<String, Object>) entry.getValue(), key + entry.getKey() + ".", flatten_dict);
			}
		}
	}

}
