package com.accpeted.submissions;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<Integer>();
        if(matrix.length == 0) return result;
        int rowEnd = matrix.length-1;
        int colEnd = matrix[0].length-1;
        int rowBegin = 0;
        int colBegin = 0;
        while(rowBegin <= rowEnd &&  colBegin <= colEnd ) {           
        for(int i=colBegin;i<=colEnd;i++){
                result.add(matrix[rowBegin][i]); 
        }
        rowBegin +=1;
        
        for(int i=rowBegin;i<=rowEnd;i++){
            result.add(matrix[i][colEnd]);
        }
        colEnd -=1; 
        // Take a 4*4 matrix to understand the below if condition.
        if(rowBegin <= rowEnd) {
            for(int i=colEnd;i>=colBegin;i--){
            result.add(matrix[rowEnd][i]); 
        }
             rowEnd -=1; 
        }
         if (colBegin <= colEnd) {
             for(int i=rowEnd;i>=rowBegin;i--){
            result.add(matrix[i][colBegin]);
        }
        colBegin +=1;
         }
        }
        return result;
    }

}
