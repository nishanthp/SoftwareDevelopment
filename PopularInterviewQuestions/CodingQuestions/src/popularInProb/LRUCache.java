package popularInProb;

import java.util.HashMap;

public class LRUCache {
	HashMap<Integer, Node> cacheMap = new HashMap<>();
	int capacity = 5;
	Node head = null;
	Node end = null;

	public static void main(String[] args) {
		LRUCache lru = new LRUCache();
		lru.set(1, 10);
		lru.set(2, 11);
		lru.set(3, 12);
		System.out.println(lru.get(2));
		System.out.println(lru.get(1));
		lru.set(4, 13);
		System.out.println(lru.get(3));
		lru.set(5, 14);
		System.out.println(lru.get(4));
		lru.set(6, 22);
	}

	public Integer get(int key) {
		if (cacheMap.containsKey(key)) {
			Node n = cacheMap.get(key);
			remove(n);
			moveNodetoHead(n);
			return n.value;
		}
		return -1;
	}

	private void moveNodetoHead(Node n) {
		n.next = head;
		n.previous = null;
		if (head != null) {
			head.previous = n;
		}
		head = n;
		// end.previous = head;
	}

	private void remove(Node n) {
		if (n.previous != null && n.next != null) {
			n.previous.next = n.next;
			n.next.previous = n.previous;
		} else if (n.previous != null) {
			end = n.previous;
		} else {
			head = n.next;
		}
	}

	public void set(int key, int value) {
		if (cacheMap.containsKey(key)) {
			Node n = cacheMap.get(key);
			remove(n);
			moveNodetoHead(n);
		} else {
			Node n = new Node(key, value);
			cacheMap.put(key, n);
			if (cacheMap.size() > capacity) {
				cacheMap.remove(end.key);
				remove(end);
			}
			moveNodetoHead(n);
		}
		if (end == null) {
			end = head;
		}
	}
}

class Node {
	Node next;
	Node previous;
	int key;
	int value;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
	}

}
