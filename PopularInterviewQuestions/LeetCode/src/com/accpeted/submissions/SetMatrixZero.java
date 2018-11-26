package com.accpeted.submissions;

public class SetMatrixZero {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	public void setZeroes(int[][] matrix) {
		// Below two lines are important. What would happen if first row, col is 0 in the original matrix.
        boolean row = false;
        boolean col = false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0) {
                    if(i==0) row = true;
                    if(j==0) col = true;
                     matrix[i][0] = 0;
                     matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                     matrix[i][j] = 0;
                }
            }
        }
        
        if(row){
            for(int j=0;j<matrix[0].length;j++) matrix[0][j] = 0;
        }
        
        if(col){
            for(int i=0;i<matrix.length;i++) matrix[i][0] = 0;
        }
    }

}
