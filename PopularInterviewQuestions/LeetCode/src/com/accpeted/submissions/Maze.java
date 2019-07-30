package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.Queue;

public class Maze {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze.length==0 || maze[0].length==0) return true;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        boolean[][]visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] temp = queue.poll();
                if(temp[0] == destination[0] && temp[1] == destination[1]) return true;  
                int currx = temp[0];
                int curry = temp[1];
                for(int[]each : dir) { 
                     currx = temp[0];
                     curry = temp[1];
                    while(currx >= 0 && currx < maze.length && curry >= 0 && curry < maze[0].length && maze[currx][curry] == 0){
                        currx += each[0];
                        curry += each[1];
                    }
                    // One step back.
                    currx -= each[0];
                    curry -= each[1];
                    if(!visited[currx][curry]) {
                        visited[currx][curry] = true;
                        queue.offer(new int[]{currx, curry});
                    }
                    
                }
            }
        }
        return false;
    }

}
