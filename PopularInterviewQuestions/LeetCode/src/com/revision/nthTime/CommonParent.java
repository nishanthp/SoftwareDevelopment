package com.revision.nthTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;


public class CommonParent {
	static boolean s1Found = false;
	static boolean s2Found = false;
	//static String commonParent = null;
	public static void main(String[] args) {
		System.out.println(3/2);
		StringBuffer sb = new StringBuffer();
		sb.append('1');
		System.out.println(sb.toString());
		
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		q.add(2);
		q.add(3);
		q.add(499);
		for(Integer e : q) {
			System.out.println(e);
		}
		System.out.println("q size " + q.size());
		// Airbnb phone interview.
		List<List<String>> lists = new LinkedList<>();
		lists.add(Arrays.asList("Earth", "USA", "Canada", "Mexico"));
		lists.add(Arrays.asList("USA", "SJ", "Seattle"));
		lists.add(Arrays.asList("Mexico", "mexicocity", "mexicocity2"));
		lists.add(Arrays.asList("Canada", "vancover", "vancovereast"));
		
		HashMap<String, List<String>> map = new HashMap<>();
		// populate the map.
		for(List<String> list : lists) {
			List<String> temp = new ArrayList<>();
			temp.addAll(list.subList(1, list.size()));
			map.putIfAbsent(list.get(0), temp);	
		}

		String root = null;
		if(map.entrySet().iterator().hasNext()) {
			root = map.entrySet().iterator().next().getKey();
		}
		
		System.out.println(findCommonParent(map, root, "USA", "Seattle"));
	}

	private static String findCommonParent(HashMap<String, List<String>> map, String index, String s1, String s2) {
		List<String> children = map.getOrDefault(index, new ArrayList<String>());
		if(index.equals(s1) || index.equals(s2)) return index;
		String temp  = null;
		int count = 0;
		for(String child : children) {
			String lowestCommon = findCommonParent(map, child, s1, s2);
			if (lowestCommon != null) {
				count +=1;
				temp = lowestCommon;
			}
		}
		if(count == 2) return index;
		return temp;
	}	
}
