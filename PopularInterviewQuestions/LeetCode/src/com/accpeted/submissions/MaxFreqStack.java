package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

public class MaxFreqStack {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
}
class FreqStack {
	
	List<Deque<Integer>> bucket; 
    HashMap<Integer, Integer> numCount;
    int pushIndex = 0;
    public FreqStack() {
        bucket = new ArrayList<>();
        numCount = new HashMap<Integer, Integer>();
    }
    
    public void push(int x) {
            numCount.putIfAbsent(x, 0);
            numCount.put(x, numCount.get(x)+1);
            int freq = numCount.get(x);
            if(freq-1 >= bucket.size()) {
                bucket.add(new ArrayDeque<Integer>());
            }
            bucket.get(freq-1).push(x);
        
    }
    
    public int pop() {
        if (bucket.size() == 0) return -1;
        int ret = bucket.get(bucket.size()-1).pop();
        numCount.put(ret, numCount.getOrDefault(ret, 0)-1);
        if(numCount.get(ret) < 0) numCount.remove(ret);
        if(bucket.get(bucket.size()-1).size() == 0) bucket.remove(bucket.size()-1);
        return ret;
}
}

