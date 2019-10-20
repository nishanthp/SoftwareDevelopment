package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoComplete {

	private class Node {
		Map<Character, Node> children = new HashMap<>();
		List<String> list = new ArrayList<>();
	}
	private Node root;
	private final int N = 3;
	private Map<String, Integer> cnts;
	private Node curNode;
	private StringBuilder entered;

	public AutoComplete(String[] sentences, int[] times) {
		root = new Node();
		curNode = root;
		entered = new StringBuilder();
		cnts = new HashMap<>();
		for (int i = 0; i < sentences.length; ++i) {
			insert(sentences[i], times[i]);
		}
	}

	private void insert(String word, int cnt) {
		Node cur = root;
		cnts.put(word, cnts.getOrDefault(word, 0) + cnt);
		for (char c : word.toCharArray()) {
			cur.children.putIfAbsent(c, new Node());
			cur = cur.children.get(c);
			insert(word, cur);
		}
	}

	private void insert(String word, Node cur) {
		if (!cur.list.contains(word)) {
			cur.list.add(word);
		}
		Collections.sort(cur.list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int ca = cnts.get(o1);
				int cb = cnts.get(o2);
				if (ca == cb)
					return o1.compareTo(o2);
				else
					return cb - ca;
			}

		});
		if (cur.list.size() > N) {
			cur.list.remove(cur.list.size() - 1);
		}
	}

	public List<String> input(char c) {
		if (c != '#') {
			entered.append(c);
			curNode.children.putIfAbsent(c, new Node());
			curNode = curNode.children.get(c);
			return curNode.list;
		}

		insert(entered.toString(), 1);
		curNode = root;
		entered = new StringBuilder();
		return new ArrayList<String>();
	}
	public static void main(String[] args) {
		String[] sentences = {"island", "ironman", "i love you",
				"i love leetcode"};
		int[] times = {5, 3, 2, 2};
		AutoComplete ac = new AutoComplete(sentences, times);
		for (String list : ac.input('i')) {
			System.out.println(list);
		}

	}
}
