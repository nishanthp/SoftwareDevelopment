package com.common.templates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Permutation {

	static List<List<Integer>> result = new LinkedList<List<Integer>>();
	public static void main(String[] args) {
		int[] input = {1,3,5};
		permutate(input, new ArrayList<Integer>());
		for(List<Integer> each : result) {
			for(int e : each) {
				System.out.print(e);
			}
			System.out.println(" ");
		}

	}

	private static void permutate(int[] input, ArrayList<Integer> list) {
		if(list.size() >= input.length) {
			List<Integer> temp = new ArrayList<Integer>();
			temp.addAll(list);
			result.add(temp);
			return;
		}
		
		for(int i=0;i<input.length;i++) {
			if(list.contains(input[i])) continue;
			list.add(input[i]);
			permutate(input, list);
			list.remove(list.size()-1);
		}
		return;
	}

}