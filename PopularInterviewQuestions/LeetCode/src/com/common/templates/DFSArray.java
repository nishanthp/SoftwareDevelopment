package com.common.templates;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class DFSArray {
	public static void main(String[] args) {
		int[] input = {1, 2, 4, 5};
		dfs(input);
	}

	public static void dfs(int[] array) {
		Set<Integer> set = new HashSet<Integer>();
		dfsOneWay(array, 0, set);
		System.out.println(" ");
		dfsSecondWay(array, 0, set);
	}

	private static void dfsOneWay(int[] array, int index, Set<Integer> set) {
		if (index >= array.length - 1) {
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				System.out.print(iter.next());
			}
			System.out.println();
		}

		for (int i = index; i < array.length; i++) {
			set.add(array[i]);
			dfsOneWay(array, i + 1, set);
			set.remove(array[i]);
		}
	}

	private static void dfsSecondWay(int[] array, int index, Set<Integer> set) {
		if (index >= array.length) {
			Iterator<Integer> iter = set.iterator();
			while (iter.hasNext()) {
				System.out.print(iter.next());
			}
			System.out.println();
			return;
		}

		// for (int i = index; i < array.length; i++) {
		set.add(array[index]);
		dfsSecondWay(array, index + 1, set);
		set.remove(array[index]);
		dfsSecondWay(array, index + 1, set);
		// }
	}

}
