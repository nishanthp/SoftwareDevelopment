package com.revision.nthTime;

import java.util.LinkedList;
import java.util.List;

public class GenericSolutions {

	public static void main(String[] args) {
		int[] n = {1,2,3,4,5};
		for(List<Integer> list : getAllCombinations(n)) {
			for(Integer each :list) {
				System.out.print(each);
			}
			System.out.println();
		}

	}
	static List<List<Integer>> result = new LinkedList<>();
	static List<Integer> temp = new LinkedList<Integer>();
	public static List<List<Integer>> getAllCombinations(int[] n) {
		return getAll(n);
	}

	private static List<List<Integer>> getAll(int[] n) {
		if(temp.size() == n.length) {
			List<Integer> t = new LinkedList<Integer>();
			t.addAll(temp);
			result.add(t);
		}
		List<Integer> temp = new LinkedList<Integer>();
		for(int i=0;i<n.length;i++) {
			temp.add(i);
			getAll(n);
			temp.remove(temp.size()-1);
		}
		return result;
	}

}
