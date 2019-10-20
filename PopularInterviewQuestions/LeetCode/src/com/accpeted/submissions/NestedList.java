package com.accpeted.submissions;

import java.util.List;

public class NestedList {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	
	public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }
    
    public int depthSum(List<NestedInteger> nestedList, int depth){
        int sum = 0;
        int runningSum = 0;
        for(NestedInteger num : nestedList){
            if(num.isInteger()){
                sum += num.getInteger();
            } 
            else {
                runningSum += depthSum(num.getList(), depth+1);         
            }
        }
        return depth * sum + runningSum;
    }

}

interface NestedInteger{
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	     public boolean isInteger();
	
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // Set this NestedInteger to hold a single integer.
	      public void setInteger(int value);
	 
	      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
	      public void add(NestedInteger ni);
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
}