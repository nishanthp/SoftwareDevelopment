package com.accpeted.submissions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathOfAllNodes {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	public int shortestPathLength(int[][] graph) {
        Queue<int[]> queue = new LinkedList<int[]>();
        HashSet<String> set = new HashSet<String>();
        int mask=0;
        int count=0;
        for(int i=0;i<graph.length;i++){
            mask |= (1<<i);
            set.add((1<<i)+"+"+i);
            queue.offer(new int[]{(1<<i), i});
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] curr = queue.poll();
                if(curr[0] == mask) return count;
                for(int next : graph[curr[1]]){
                    int states = (1 << next);
                    states |= curr[0];
                    if(!set.contains(states+"+"+next)){
                        set.add(states+"+"+next);
                        queue.offer(new int[]{states, next});
                        
                    }
                }
                
            }
            count+=1;
        }
        return -1;
    }

}
