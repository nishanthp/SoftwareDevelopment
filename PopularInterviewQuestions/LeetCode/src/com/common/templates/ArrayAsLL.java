package com.common.templates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class ArrayAsLL {

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			lists.add(new ArrayList<Integer>());
		}
//		String hostname = "rno-1234.ebay.com";
//		String[] hs = hostname.split(".");
//		System.out.println(hs[0]);

		List<String> tagKeyValueList = new ArrayList<String>();

		tagKeyValueList.add("123");
		tagKeyValueList.add("321");

		String[] what = tagKeyValueList.toArray(new String[1]);
		for (String i : what) {
			System.out.println("Hello " + i);
		}

		Pattern pattern = Pattern.compile("nudata.cdc.staging.CoreOrderManagementSystem.*");

		String s = "lvs,rno";
		System.out.println("is it? " + s.contains("rno"));

		int i = 90;
		System.out.println((long) i);

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

	private static void printColumnByColumn(List<List<Integer>> lists, List<Iterator<Integer>> iterators, int index,
			int maxSize) {
		if (index >= maxSize)
			return;

		for (int i = 0; i < lists.size(); i++) {
			Iterator<Integer> curr = iterators.get(i);
			if (curr.hasNext())
				System.out.println(curr.next());
		}
		printColumnByColumn(lists, iterators, index + 1, maxSize);
	}
}