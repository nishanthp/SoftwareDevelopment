package com.common.templates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combination {

	static List<List<Integer>> result = new LinkedList<List<Integer>>();
	public static void main(String[] args) {
		int[] input = {1,3,5};
		subSet(input, 0, new ArrayList<Integer>());
		for(List<Integer> each : result) {
			for(int e : each) {
				System.out.print(e);
			}
			System.out.println(" ");
		}

	}

	private static void subSet(int[] input, int index, ArrayList<Integer> list) {
		if(index >= input.length) {
			List<Integer> temp = new LinkedList<Integer>();
			temp.addAll(list);
			result.add(temp);
			return;
		}
		for(int i=index; i<input.length;i++) {
			list.add(input[i]);
			subSet(input, i+1, list);
			list.remove(list.size()-1);
		}
	}
}
