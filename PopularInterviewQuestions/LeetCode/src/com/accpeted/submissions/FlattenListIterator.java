package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class FlattenListIterator {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public class NestedIterator implements Iterator<Integer> {
	    Deque<List<NestedInteger>> stack = new ArrayDeque<>();
	    List<Integer> flattenList;
	    int currPointer;
	    public NestedIterator(List<NestedInteger> nestedList) {
	        this.flattenList = new LinkedList<Integer>();
	        currPointer = 0;
	        flatten(nestedList);
	    }
	    
	    
	    private void flatten(List<NestedInteger> nestedList) {
	        for(NestedInteger each : nestedList){
	            if(each.isInteger()) this.flattenList.add(each.getInteger());
	            else flatten(each.getList());
	        }
	        
	    }

	    @Override
	    public Integer next() {
	        return this.flattenList.get(currPointer++);
	    }

	    @Override
	    public boolean hasNext() {
	        return currPointer < this.flattenList.size();
	}
	}

}
