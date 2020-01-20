package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;

public class DeleteGetRandom {

	public static void main(String[] args) {
		// Ran on leetcode.
		// Important Run it.
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(1);
		l.remove(1); // removes the first instance. lowest index.
		System.out.println(l.size());

		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1);
		q.offer(1);
		q.remove(1); // removes the first instance.
		System.out.println(q.size());
	}
	class RandomizedCollection {
		Map<Integer, LinkedHashSet<Integer>> map;
		List<Integer> list;
		Random r;
		/** Initialize your data structure here. */
		public RandomizedCollection() {
			map = new HashMap<Integer, LinkedHashSet<Integer>>();
			list = new ArrayList<Integer>();
			r = new Random();
		}

		/**
		 * Inserts a value to the collection. Returns true if the collection did
		 * not already contain the specified element.
		 */
		public boolean insert(int val) {
			if (map.containsKey(val)) {
				LinkedHashSet<Integer> q = map.get(val);
				q.add(list.size());
				list.add(val);
				return false;
			}
			map.put(val, new LinkedHashSet<Integer>());
			map.get(val).add(list.size());
			list.add(val);
			return true;
		}

		/**
		 * Removes a value from the collection. Returns true if the collection
		 * contained the specified element.
		 */
		public boolean remove(int val) {
			if (map.containsKey(val)) {

				int removeIndex = map.get(val).iterator().next();
				map.get(val).remove(removeIndex);

				if (removeIndex < list.size() - 1) {
					int lastElement = list.get(list.size() - 1);
					list.set(removeIndex, lastElement);
					map.get(lastElement).remove(list.size() - 1);
					map.get(lastElement).add(removeIndex);
				}

				if (map.get(val).size() == 0)
					map.remove(val);
				list.remove(list.size() - 1);
				return true;
			}
			return false;

		}

		/** Get a random element from the collection. */
		public int getRandom() {
			if (list.size() == 0)
				return 0;
			int index = r.nextInt(list.size());
			return list.get(index);
		}
	}

}
