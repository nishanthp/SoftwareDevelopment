package com.accpeted.submissions;

import java.util.HashMap;

public class Trie {

	public static void main(String[] args) {
		// Ran on leetcode.
	}

	    TrieNode root = null;
	    /** Initialize your data structure here. */
	    public Trie() {
	        root = new TrieNode(' ');
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        TrieNode head = root; 
	        for(int i=0;i<word.length();i++){
	            if(head.children.containsKey(word.charAt(i))){
	                head = head.children.get(word.charAt(i));
	                if(word.length()-1 == i) {
	                head.isLeafNode = true;
	                return;
	            }
	                continue;
	            }else {           
	            TrieNode temp = new TrieNode(word.charAt(i));
	            if(word.length()-1 == i) {
	                temp.isLeafNode = true;
	            }
	            HashMap<Character, TrieNode> tempHashMap = head.children;
	            tempHashMap.put(word.charAt(i), temp);
	            head = temp;
	                
	            }           
	        }
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        TrieNode head = root; 
	        for(int i=0;i<word.length();i++){
	            if(head.children.containsKey(word.charAt(i))){
	                 TrieNode nextChar = head.children.get(word.charAt(i));
	                 if(word.length()-1 == i && nextChar.isLeafNode) {
	                     return true;
	                 }
	                 // if(word.length-1 == i && !nextChar.isLeafNode) {
	                 //     return false;
	                 // }
	                 head = nextChar;
	            }else {
	                return false;
	            }
	        }
	        return false;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	        TrieNode head = root; 
	        for(int i=0;i<prefix.length();i++){
	            if(head.children.containsKey(prefix.charAt(i))){
	                 TrieNode nextChar = head.children.get(prefix.charAt(i));
	                 head = nextChar;
	            }else {
	               return false; 
	            }
	        }
	        return true;
	    }
	

	class TrieNode{
	    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	    boolean isLeafNode = false;
	    Character c = null;
	    TrieNode(Character c){
	        this.c = c;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */
}
