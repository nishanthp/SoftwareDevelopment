package com.common.templates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayAsLL {

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			lists.add(new ArrayList<Integer>());
		}
		lists.get(0).add(1);
		lists.get(0).add(7);
		lists.get(0).add(8);
		lists.get(0).add(19);

		lists.get(1).add(5);
		lists.get(1).add(6);
		lists.get(1).add(7);

		lists.get(2).add(48);
		lists.get(2).add(49);
		lists.get(2).add(50);

		List<Iterator<Integer>> iterators = new ArrayList<>();
		int maxSize = Integer.MIN_VALUE;
		for (List<Integer> list : lists) {
			maxSize = Math.max(maxSize, list.size());
			iterators.add(list.iterator());
		}

		printColumnByColumn(lists, iterators, 0, maxSize);
	}

	private static void printColumnByColumn(List<List<Integer>> lists,
			List<Iterator<Integer>> iterators, int index, int maxSize) {
		if (index >= maxSize)
			return;

		for(int i=0;i<lists.size();i++) {
			Iterator<Integer> curr = iterators.get(i);
			if(curr.hasNext()) System.out.println(curr.next());
		}
		printColumnByColumn(lists, iterators, index+1, maxSize);
	}

}