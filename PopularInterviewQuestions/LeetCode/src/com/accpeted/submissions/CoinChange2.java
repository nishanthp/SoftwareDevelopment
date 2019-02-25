package com.accpeted.submissions;

public class CoinChange2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// number of combinations. 
	// if j >= coins[i-1]
	// m[i][j] = m[i-1][j] || m[i][j-coins[i-1]]
	// else m[i][j] = m[i-1][j].
	 public int change(int amount, int[] coins) {
	        int[][] matrix = new int[coins.length+1][amount+1];
	        
	        for(int i=0;i<matrix.length;i++){
	            matrix[i][0] = 1; //this is the confusing part. The number of ways you can make 
	                  			  // 0 amount with any denominations is 0.
	        }
	        for(int i=1;i<matrix.length;i++){
	            for(int j=1;j<matrix[0].length;j++){
	                if(j>=coins[i-1]) {
	                    matrix[i][j] = matrix[i][j-coins[i-1]] + matrix[i-1][j];
	                    System.out.println(matrix[i][j]);
	                } else {
	                    matrix[i][j] = matrix[i-1][j];
	                }
	            }
	        }
	        return matrix[coins.length][amount];
	    }

}
