package com.common.templates;

import java.util.ArrayList;
import java.util.List;

public class ArrayAsLL {

	public static void main(String[] args) {
		List<List<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			lists.add(new ArrayList<Integer>());
		}

	}

}