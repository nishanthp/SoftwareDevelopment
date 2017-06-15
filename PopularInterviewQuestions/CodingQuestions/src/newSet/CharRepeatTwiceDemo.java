package newSet;

import java.util.PriorityQueue;

public class CharRepeatTwiceDemo {
	public static void main(String[] args) {
		CharRepeatTwiceDemo d = new CharRepeatTwiceDemo();
		String output = d.rearrange("aab");
		System.out.println(output);
	}

	public String rearrange(String input) {
		PriorityQueue<CharFreq> queue = new PriorityQueue<>();
		int[] charFreq = new int[256];
		StringBuffer s = new StringBuffer();

		for (char c : input.toCharArray()) {
			charFreq[c]++;
		}

		for (int i = 0; i < 256; i++) {
			if (charFreq[i] > 0) {
				queue.add(new CharFreq((char) i, charFreq[i]));
			}
		}
		while (!queue.isEmpty()) {
			CharFreq first = queue.poll();
			s.append(first.ch);
			first.freq--;
			if (first != null && first.freq != 0) {
				queue.add(first);
			}
		}

		return s.toString();

	}

	static class CharFreq implements Comparable<CharFreq> {
		char ch;
		int freq;

		CharFreq(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}

		@Override
		public int compareTo(CharFreq cf) {
			int comp = Integer.compare(cf.freq, freq);
			if (comp == 0) {
				comp = Character.compare(cf.ch, ch);
			}
			return comp;
		}

	}
}
