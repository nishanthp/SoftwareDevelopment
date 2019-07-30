package com.accpeted.submissions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Maze2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze.length == 0 || maze[0].length == 0) return 0;
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][]distance = new int[maze.length][maze[0].length];
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(start);
        int steps = 0;
        for(int[] dis : distance){
            Arrays.fill(dis, -1);
        }
        distance[start[0]][start[1]] = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                int[] temp = queue.poll(); 
                int currx = temp[0];
                int curry = temp[1];
                for(int[]each : dir) { 
                     currx = temp[0];
                     curry = temp[1];
                     steps = distance[temp[0]][temp[1]];
                    while(currx >= 0 && currx < maze.length && curry >= 0 && curry < maze[0].length && maze[currx][curry] == 0){
                        currx += each[0];
                        curry += each[1];
                        steps +=1;
                    }
                    // One step back.
                    currx -= each[0];
                    curry -= each[1];
                    steps -=1;
                    if(distance[currx][curry] == -1 || distance[currx][curry] > steps) {
                        distance[currx][curry] = steps;
                        queue.offer(new int[]{currx, curry});
                    }
                    
                }
            }
        }
        // this is important part. Do not return when you found the destination the first time.
        return distance[destination[0]][destination[1]];
    
    }

}
