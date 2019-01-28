package com.accpeted.submissions;

import java.util.HashMap;

public class LRUCache {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	 HashMap<Integer,Node1> cache;
	    int capacity = 0;
	    Node1 head;
	    Node1 tail;
	   
	    public LRUCache(int capacity) {
	        this.cache = new HashMap<Integer, Node1>();
	        this.capacity = capacity;
	        // This is the important part. Can avoid null pointer exception by making 
	        // head and tail dummy nodes. Can avoid multiple checks for helper methods.
	        head = new Node1(0,0);
	        tail = new Node1(0,0);
	        head.next=tail;
	        tail.prev = head;
	    }
	    
	    public int get(int key) {
	        if(!cache.containsKey(key)) return -1;
	        else{
	            Node1 current = this.cache.get(key);
	            removeNode(current);
	            moveNodeToHead(current);
	            return current.getValue();
	        }
	    }
	    
	    public void put(int key, int value) {
	        Node1 current;
	        if (cache.containsKey(key)){
	            current = cache.get(key);
	            current.val = value;
	            removeNode(current);
	        } else {
	            current = new Node1(key, value);
	            this.cache.put(key, current);
	            if(this.cache.size() > this.capacity){
	            int outKey = this.tail.prev.getKey();
	            removeNode(this.tail.prev);
	            this.cache.remove(outKey);
	        } 
	        
	        }
	        moveNodeToHead(current);
	    }
	    
	    private void moveNodeToHead(Node1 current){
	        current.next = this.head.next;
	        current.next.prev = current;
	        current.prev=head;
	        this.head.next = current;
	    }
	    
	    private void removeNode(Node1 current) {
	       current.prev.next = current.next;
	       current.next.prev = current.prev;
	    }
}

class Node1 {
	int key;
    int val; 
    Node1 prev;
    Node1 next; 
    Node1(int key, int value){
    	this.key = key;
        this.val = value;
    }
    public int getValue() {return this.val;}
    public int getKey() {return this.key;}
}


