package com.accpeted.submissions;

import java.util.HashSet;

public class NumberOfDistinctIslands {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int numDistinctIslands(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int count=0;
        HashSet<String> distinct = new HashSet<String>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) {
                // This is the important point. Storing the direction as string is the key point.
                StringBuilder sb = new StringBuilder();
                dfs(grid, i, j, "s", sb);
                String currIsland = sb.toString();
                if (!distinct.contains(currIsland)) {
                    distinct.add(currIsland);
                    count+=1;
                }
                }
            }
        }
        return count;
    }
    
     public void dfs(int[][] grid, int i, int j, String direction, StringBuilder sb) {
         if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == 0) return;
         grid[i][j] = 0;
         sb.append(direction);
         dfs(grid, i-1, j, "u", sb);
         dfs(grid, i, j-1, "l", sb);
         dfs(grid, i+1, j, "d", sb);
         dfs(grid, i, j+1, "r", sb);
         sb.append("e");
     }

}
