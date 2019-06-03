package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Use the array to get the value, not hashmap.
	
	List<Integer> indexes;
    HashMap<Integer, Integer> set;
    Random r = new Random();

    /** Initialize your data structure here. */
    public RandomizedSet() {
        indexes = new ArrayList<Integer>();
        set = new HashMap<Integer,Integer>();
        r = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(set.containsKey(val)) return false;
        set.put(val,indexes.size());
        indexes.add(val);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    // Look at the below method. It improves the time complexity by a lot.
    public boolean remove(int val) {
        if(!set.containsKey(val)) return false;
        int index = set.getOrDefault(val, -1);
        if(index == -1) return false;
        Collections.swap(indexes, index, indexes.size()-1);
        int swappedWith = indexes.get(index);
        set.put(swappedWith, index);
        indexes.remove(indexes.size()-1);
        set.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int key = this.r.nextInt(indexes.size());
        int curr = indexes.get(key);
        return curr;
    }

}
