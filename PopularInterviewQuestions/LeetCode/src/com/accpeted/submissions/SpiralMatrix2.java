package com.accpeted.submissions;

public class SpiralMatrix2 {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n == 0) return matrix;
        int rowEnd = n-1;
        int colEnd = n-1;
        int rowBegin = 0;
        int colBegin = 0;
        int num = 1;
        while(rowBegin <= rowEnd &&  colBegin <= colEnd ) {           
        for(int i=colBegin;i<=colEnd;i++){
            matrix[rowBegin][i] = num++;
        }
            
        rowBegin +=1;
        
        for(int i=rowBegin;i<=rowEnd;i++){
            matrix[i][colEnd] = num++;
        }    
        colEnd -=1; 
        if(rowBegin <= rowEnd) {
            for(int i=colEnd;i>=colBegin;i--){
                matrix[rowEnd][i] = num++;
            
        }
             rowEnd -=1; 
            
        }
        
       
         if (colBegin <= colEnd) {
             for(int i=rowEnd;i>=rowBegin;i--){
                 matrix[i][colBegin] = num++;
            
        }
        colBegin +=1;
             
         }
        }
        return matrix;
    
    }

}
