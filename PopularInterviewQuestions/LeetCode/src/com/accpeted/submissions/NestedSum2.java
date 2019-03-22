package com.accpeted.submissions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedSum2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	int totalSum = 0;
    int prevSum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        Deque<NestedInteger> queue = new LinkedList<NestedInteger>();
        for(NestedInteger i : nestedList){
            queue.offer(i);
        }
        bfs(queue);
        return totalSum;
    }
    public int bfs(Queue<NestedInteger> nestedList) {
        while(!nestedList.isEmpty()){
            int size = nestedList.size();
            int levelSum = 0;
            for (int i=0;i<size;i++){
                NestedInteger curr = nestedList.poll();
                if(curr.isInteger()) levelSum += curr.getInteger();
                else {
                    for(NestedInteger next : curr.getList()){
                        nestedList.offer(next);
                    }
                }
             }
            // One of those problems. No need to use depth. Just add it again. 
            // multiplication is repeated addition.
            prevSum += levelSum;
            totalSum += prevSum;
         }
        return totalSum;
    }

}
