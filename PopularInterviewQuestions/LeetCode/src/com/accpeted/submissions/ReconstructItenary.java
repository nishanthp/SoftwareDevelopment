package com.accpeted.submissions;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItenary {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	// Useful tip: think of using queue for neighbors, that way can avoid using visited.
	public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        for(List<String> ticket : tickets){
            map.putIfAbsent(ticket.get(0), new PriorityQueue<String>(Comparator.naturalOrder()));
            PriorityQueue<String> temp = map.get(ticket.get(0));
            temp.add(ticket.get(1));
        }
        List<String> result = new LinkedList<String>();
        return dfs(map, "JFK", result);
    }
    
      public List<String> dfs(HashMap<String, PriorityQueue<String>>map, String currCity, List<String> result) {
          if (map.get(currCity) != null) {
          Queue<String> c = map.get(currCity);
              while(!c.isEmpty()) {
                  dfs(map, c.poll() , result);
              }     
          }
          result.add(0, currCity);
          return result;
      }

}
