package com.accpeted.submissions;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedSum2 {

	public static void main(String[] args) {
		// Ran on leetcode.
		List<Integer> all = new LinkedList<Integer>();
		List<Integer> all2 = new LinkedList<Integer>();
		all.addAll(all2);

	}
	
	// 1st approach using DFS. This solution is straight forward.
	List<Integer> sums = new LinkedList<Integer>();
    int level = 0;
   public int depthSumInverseDFS(List<NestedInteger> nestedList) {
       depthSumInverseDFS(nestedList, level);
       int j = 0;
       int totalSum = 0;
       level = sums.size();
       for(int eachSum : sums){
           totalSum += eachSum * level;
           level--;
           if(level == 0) break;
       }
       return totalSum;
   }
   
   public void depthSumInverseDFS(List<NestedInteger> nestedList, int level) {
       if(level >= sums.size()) sums.add(0);
       int levelSum = 0;
       for(NestedInteger each : nestedList){
           if (each.isInteger()) levelSum += each.getInteger();
           else depthSumInverseDFS(each.getList(), level+1);
       }
       levelSum +=  sums.get(level);
       sums.set(level, levelSum);
       return;
   }
	
   
    // This is second approach using BFS. Not straight forward.
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
