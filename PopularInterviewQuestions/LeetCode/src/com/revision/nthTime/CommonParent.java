package com.revision.nthTime;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;


public class CommonParent {
	static boolean s1Found = false;
	static boolean s2Found = false;
	//static String commonParent = null;
	public static void main(String[] args) {
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

		for(Entry<String, List<String>> each : map.entrySet()) {
			s1Found = false;
			s2Found = false;
			System.out.println(findCommonParent(map, each.getKey(), "", "vancover", "vancovereast"));
		}
	}

	private static String findCommonParent(HashMap<String, List<String>> map, String index, String parent, String s1, String s2) {
		List<String> children = map.getOrDefault(index, new ArrayList<String>());
		System.out.println(children.size());
		for(String child : children) {
			System.out.println(index + "   " +child);
			if(child.equals(s1)) {	
				System.out.println("here");
				s1Found = true;
			}
			if(child.equals(s2)) 
				s2Found = true;
			if(s1Found && s2Found)  {
				System.out.println(index);
				return index;
				}
			String lowestCommon = findCommonParent(map, child, parent, s1, s2);
			if (lowestCommon != null) return lowestCommon;
		}
		
		return "";
	}	
}
