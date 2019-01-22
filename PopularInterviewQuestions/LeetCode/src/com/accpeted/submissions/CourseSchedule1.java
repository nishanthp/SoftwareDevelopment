package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class CourseSchedule1 {

	public static void main(String[] args) {
		// Ran on leetcode
		// As a side note.
		// List<int[]> result = Arrays.asList(int[]);

	}
	
	// important. Please read. 
	 public boolean canFinish(int numCourses, int[][] prerequisites) {
	        if(prerequisites.length == 0) return true;
	        boolean []visited = new boolean [numCourses];
	        List<List<Integer>> graph = new LinkedList<>();
	        for(int i=0;i<numCourses;i++){
	           graph.add(new LinkedList<Integer>());
	        }
	        // How to create a matrix out of 2d matrix to perform DFS or BFS. 
	        for(int i=0;i<prerequisites.length;i++){
	            List<Integer> tmp = graph.get(prerequisites[i][1]);
	            tmp.add(prerequisites[i][0]);
	        }
	        for(int i=0;i<numCourses;i++){
	            if(!can(graph, visited, i)) return false;
	        }
	        return true;
	}
	    
	    public boolean can(List<List<Integer>> graph, boolean[] visited , int courseNum) {
	        if(visited[courseNum]) return false;
	        else visited[courseNum] = true;
	        if(courseNum >= graph.size() || graph.get(courseNum).size() == 0) {
	           visited[courseNum] = false;
	            return true;
	        }
	        List<Integer> curr = graph.get(courseNum); 
	        for(int i=0;i<curr.size();i++){
	            if(!can(graph, visited , curr.get(i))) return false;
	        }
	        visited[courseNum] = false;
	        return true;
	}

}
