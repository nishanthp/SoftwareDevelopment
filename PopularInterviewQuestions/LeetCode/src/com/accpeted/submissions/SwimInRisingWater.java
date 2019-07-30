package com.accpeted.submissions;

import java.util.HashSet;
import java.util.logging.Logger;

public class SwimInRisingWater {

	private final Logger logger = Logger.getLogger(SwimInRisingWater.this.getClass().getName());
	public static void main(String[] args) {
		// Ran on leetcode.
		System.out.println(SwimInRisingWater.class.getClass().getName());

	}
	
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    public int swimInWater(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        HashSet<Integer> visited = new HashSet<Integer>();       
        int time = 0;
        int row = grid.length;
        while(!visited.contains(row*row-1)){
            visited.clear();
            dfs(grid, visited, time, 0, 0);
            time+=1;
        }
        return time-1;
    }
    
     public void dfs(int[][] grid, HashSet<Integer> visited, int time, int i, int j) {
         if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited.contains(i*grid.length+j) || time < grid[i][j]) return ;
         visited.add(i*grid.length+j);
         for(int[] dir : dirs){
             dfs(grid, visited, time, i+dir[0], j+dir[1]);
         }
     }

}
