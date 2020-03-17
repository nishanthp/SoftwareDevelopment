package com.accpeted.submissions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class StreamOfChars {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	class StreamChecker {

		Queue<TrieNode> queue;
		TrieNode root;

		class TrieNode {
			Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
			boolean isWord = false;
			char c = ' ';
			TrieNode(char c) {
				this.c = c;
			}
		}

		public StreamChecker(String[] words) {
			queue = new LinkedList<TrieNode>();
			root = new TrieNode('X');
			queue.offer(root);
			for (String word : words) {
				TrieNode curr = root;
				for (int i = 0; i < word.length(); i++) {
					curr.children.putIfAbsent(word.charAt(i),
							new TrieNode(word.charAt(i)));
					curr = curr.children.get(word.charAt(i));
					if (i == word.length() - 1)
						curr.isWord = true;
				}
			}
		}

		public boolean query(char letter) {
			int size = queue.size();
			boolean res = false;
			for (int i = 0; i < size; i++) {
				TrieNode curr = queue.poll();
				if (curr.children.containsKey(letter)) {
					queue.offer(curr.children.get(letter));
					if (curr.children.get(letter).isWord)
						res = true;
				}
				if (curr == root) {
					queue.offer(root);
				}
			}
			return res;
		}
	}

}
