package com.accpeted.submissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelay {

	
	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int networkDelayTime(int[][] times, int N, int K) {
        if(times == null || times.length == 0) return 0;
        // populate the graph.
        HashMap<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] time : times){
            graph.putIfAbsent(time[0], new HashMap<Integer, Integer>());
            graph.get(time[0]).put(time[1], time[2]);
        }
        
        PriorityQueue<int[]> queue = new  PriorityQueue<int[]>(new Comparator<int[]>(){
            @Override
            public int compare(int[] n1, int[] n2){
                return Integer.compare(n1[0], n2[0]);
            }
        });
        int res = 0;
        boolean[] visited = new boolean[N+1];
        queue.add(new int[]{0, K}); // starting point with distance 0.
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int currNode = curr[1];
            int currDis = curr[0];
            if(visited[currNode]) continue;
            visited[currNode] = true;
            N-=1;
            res = currDis;
            if(graph.containsKey(currNode)) {
                for(int neigbhor : graph.get(currNode).keySet()) {
                    queue.add(new int[]{currDis+graph.get(currNode).get(neigbhor), neigbhor});
                }
            }
        }
        return N == 0 ? res : -1;
    }

}
