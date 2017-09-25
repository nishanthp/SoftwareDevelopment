package MSFT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class RemoveTopkElementsDemo {
	static HashMap<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		PriorityQueue<WordFreq> maxHeap = new PriorityQueue<>();
		ArrayList<String> words = new ArrayList<>();
		words.add("a");
		words.add("a");
		words.add("a");

		words.add("b");
		words.add("b");
		words.add("b");
		words.add("b");

		words.add("x");
		words.add("y");
		int k = 2;
		RemoveTopkElementsDemo d = new RemoveTopkElementsDemo();
		d.populateData(words);

		for (Entry<String, Integer> entry : map.entrySet()) {
			maxHeap.add(new WordFreq(entry.getKey(), entry.getValue()));
		}

		while (k > 0) {
			System.out.println(maxHeap.poll().word);
			k--;
		}

	}

	public void populateData(ArrayList<String> words) {
		for (String eachWord : words) {
			if (map.containsKey(eachWord)) {
				map.put(eachWord, map.get(eachWord) + 1);
			} else {
				map.put(eachWord, 1);
			}
		}

	}
}

class WordFreq implements Comparable<WordFreq> {
	String word;
	Integer freq;

	public WordFreq(String word, Integer freq) {
		this.word = word;
		this.freq = freq;
	}

	@Override
	public int compareTo(WordFreq word) {
		return word.freq.compareTo(this.freq);
	}

}
