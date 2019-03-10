package com.accpeted.submissions;

public class FriendCircles {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// ok. This is not a matrix dfs problem. Matrix is used to represent a graph.
	// View it as a graph. Can be done using bfs too. Also union find.
	public int findCircleNum(int[][] M) {
        if(M.length == 0 || M[0].length == 0) return 0;
        int count = 0;
        int[] visited = new int[M.length];
        for(int i=0;i<M.length;i++) {
            if(visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            } 
           }       
         return count;
        }

    public void dfs(int[][] M, int[] visited, int i) {
        visited[i] = 1;
        for(int j = 0; j < M[0].length; j++){
           if(M[i][j] == 1 && visited[j] == 0) {
               dfs(M, visited, j);         
           }
       }
        return;
    }

}
