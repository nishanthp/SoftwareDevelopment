package newSet;

import java.util.HashMap;
import java.util.Map.Entry;

public class FlattenDictDemo {
	public static void main(String[] args) {

		HashMap<String, Object> dictc = new HashMap<>();
		dictc.put("d", "3");
		dictc.put("e", "2");

		HashMap<String, Object> dictKey2 = new HashMap<>();
		dictKey2.put("a", "2");
		dictKey2.put("b", "3");
		dictKey2.put("c", dictc);

		HashMap<String, Object> dict = new HashMap<>();
		dict.put("key1", "1");
		dict.put("Key2", dictKey2);

		HashMap<String, Object> flatten_dict = new HashMap<>();
		FlattenDictDemo d = new FlattenDictDemo();
		d.flattenDict(dict, "", flatten_dict);

		for (Entry<String, Object> entry : flatten_dict.entrySet()) {
			System.out.println(entry.getKey()+" "+ entry.getValue());
		}
	}

	public void flattenDict(HashMap<String, Object> dict, String key, HashMap<String, Object> flatten_dict) {
		for (String eachKey : dict.keySet()) {
			if (dict.get(eachKey) instanceof String) {
				flatten_dict.put(key + eachKey, dict.get(eachKey));
			} else if (dict.get(eachKey) instanceof Object) {
				flattenDict((HashMap<String, Object>) dict.get(eachKey), key + eachKey + ".", flatten_dict);
			}
		}
	}

}
