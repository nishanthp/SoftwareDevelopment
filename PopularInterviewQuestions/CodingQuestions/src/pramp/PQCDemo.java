package pramp;

import java.util.Comparator;
import java.util.PriorityQueue;

// should understand this more before interview.
public class PQCDemo {
	public static void main(String[] args) {
		PriorityQueue<Integer> q = new PriorityQueue<>(new Comp());
		q.add(12);
		q.add(22);
		q.add(42);
		q.add(15);
		q.add(1);
		q.add(76);
		while (!q.isEmpty()) {
			System.out.println(q.poll());
		}
	}

}

class Comp implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		return o1.compareTo(o2);
	}

}