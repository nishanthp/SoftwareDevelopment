package practise;

import java.util.HashMap;

public class TrieDemo {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("thisisfun");
		if (trie.startsWith("this")) {
			System.out.println("Prefix functionality works.");
		}
		if (trie.search("thisisfun")) {
			System.out.println("Word functionality works.");
		}
		if (trie.search("this")) {
			System.out.println("This should not be printed.");
		}

	}

}

class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode temp;
		for (int i = 0; i < word.length(); i++) {
			if (children.containsKey(word.charAt(i))) {
				temp = children.get(word.charAt(i));
			} else {
				temp = new TrieNode(word.charAt(i));
				children.put(word.charAt(i), temp);
			}
			children = temp.children;
			if (i == word.length() - 1) {
				temp.isleaf = true;
			}
		}
	}

	public boolean search(String word) {
		TrieNode temp = searchTrie(word);
		if (null != temp && temp.isleaf) {
			return true;
		} else
			return false;
	}

	public boolean startsWith(String word) {
		TrieNode temp = searchTrie(word);
		if (null != temp) {
			return true;
		} else
			return false;
	}

	public TrieNode searchTrie(String word) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode lastNodeSoFar = null;
		for (int i = 0; i < word.length(); i++) {
			if (children.containsKey(word.charAt(i))) {
				lastNodeSoFar = children.get(word.charAt(i));
				children = lastNodeSoFar.children;
			} else
				return null;
		}
		return lastNodeSoFar;
	}
}

class TrieNode {
	char c;
	HashMap<Character, TrieNode> children = new HashMap<>();
	boolean isleaf = false;

	public TrieNode() {
		// TODO Auto-generated constructor stub
	}

	public TrieNode(char character) {
		this.c = character;
	}
}
