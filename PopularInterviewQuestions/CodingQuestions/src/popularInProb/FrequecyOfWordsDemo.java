package popularInProb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.TreeSet;

public class FrequecyOfWordsDemo {
	static TreeMap<String, Integer> words = new TreeMap<>();

	public static void main(String[] args) throws IOException {
		String filePath = "C:" + File.separator + "text.txt";
		FileReader file = new FileReader(filePath);
		BufferedReader reader = new BufferedReader(file);
		String line;
		while ((line = reader.readLine()) != null) {
			String[] word = line.split(" ");
			for (String everyWord : word) {
				if (words.containsKey(everyWord)) {
					words.put(everyWord, words.get(everyWord) + 1);
				} else {
					words.put(everyWord, 1);
				}
			}
		}

		ModifiedComp c = new ModifiedComp(words);
		TreeMap<String, Integer> sortMap = new TreeMap<>(c);
		sortMap.putAll(words);

		// print.
		for (Entry<String, Integer> entry : sortMap.entrySet()) {
			System.out.println(entry.getKey() + "    " + entry.getValue());
		}
	}
}

class ModifiedComp implements Comparator<String> {
	TreeMap<String, Integer> map = new TreeMap<>();

	public ModifiedComp(TreeMap<String, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return map.get(o2).compareTo(map.get(o1));
	}

}
