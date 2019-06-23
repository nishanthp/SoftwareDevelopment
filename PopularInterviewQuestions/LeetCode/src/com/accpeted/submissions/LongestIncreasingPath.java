package com.accpeted.submissions;

public class LongestIncreasingPath {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        int maxLength = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int currMax = dfs(matrix, cache, i, j , Integer.MAX_VALUE);
                maxLength = Math.max(maxLength, currMax);
            }
        }
        return maxLength;
    }
	// important point here is to store the max value coming from 4 directions, and then 
	// returning it back. Classic dfs with memoization.
     public int dfs(int[][] matrix, int[][] cache, int i, int j , int prev){
         if(i < 0 || j < 0 || i>matrix.length-1 || j>matrix[0].length-1) return 0;
         if(prev <= matrix[i][j]) return 0;
         if (cache[i][j] > 0) return cache[i][j];
         int maxCount = 0 ;
         maxCount = Math.max (dfs(matrix, cache, i+1, j , matrix[i][j]), maxCount);
         maxCount = Math.max (dfs(matrix, cache, i, j+1 , matrix[i][j]), maxCount);
         maxCount = Math.max (dfs(matrix, cache, i-1, j , matrix[i][j]), maxCount);
         maxCount = Math.max (dfs(matrix, cache, i, j-1 , matrix[i][j]), maxCount);
         cache[i][j] = maxCount+1;
         return cache[i][j]; 
     }

}
