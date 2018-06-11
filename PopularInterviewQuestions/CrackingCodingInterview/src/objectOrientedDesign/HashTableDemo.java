package ObjectOrientedDesign;

import java.util.ArrayList;

public class HashTableDemo {

	public static void main(String[] args) {
		Hasher<Integer, Integer> hashmap = new Hasher(5);
		hashmap.put(3, 41);
		hashmap.put(4, 42);
		hashmap.put(5, 43);
		hashmap.put(6, 44);
		hashmap.put(7, 45);
		System.out.println(hashmap.get(7));
		hashmap.remove(6);
		System.out.println(hashmap.get(6));
	}
}

class Hasher<K, V> {

	private class LinkedListNode<K, V> {
		K key;
		V value;
		LinkedListNode<K, V> next;
		LinkedListNode<K, V> prev;

		public LinkedListNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	ArrayList<LinkedListNode<K, V>> array = new ArrayList<>();

	public Hasher(int size) {
		array.ensureCapacity(size);
		for (int i = 0; i < size; i++) {
			array.add(null);
		}
	}

	public V put(K key, V value) {
		LinkedListNode<K, V> node = getNodeForIndex(key);
		if (node != null) {
			V oldValue = node.value;
			node.value = value;
			return oldValue;
		}
		LinkedListNode<K, V> current = new LinkedListNode(key, value);
		int hashKey = getIndexForKey(key);
		if (array.get(hashKey) != null) {
			current.next = array.get(hashKey);
			current.next.prev = current;
		}
		array.set(hashKey, current);
		return null;
	}

	public V get(K key) {
		LinkedListNode<K, V> node = getNodeForIndex(key);
		if (node != null) {
			return node.value;
		}
		return null;
	}

	public V remove(K key) {
		LinkedListNode<K, V> node = getNodeForIndex(key);
		if (node != null) {
			if (node.prev != null) {
				node.prev.next = node.next;
			} else {
				int hashKey = getIndexForKey(key);
				array.set(hashKey, node.next);
			}

			if (node.next != null) {
				node.next.prev = node.prev;
			}
			return node.value;
		}
		return null;
	}

	public LinkedListNode<K, V> getNodeForIndex(K key) {
		int hashKey = getIndexForKey(key);
		LinkedListNode<K, V> current = array.get(hashKey);
		while (current != null) {
			if (current.key == key) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	public int getIndexForKey(K key) {
		return Math.abs(key.hashCode() % array.size());
	}
}