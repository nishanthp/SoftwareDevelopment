package com.accpeted.submissions;

import java.util.List;

public class ValidWordSquare {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	int colLength = 0; 
    public boolean validWordSquare(List<String> words) {
        int row = 0;     
        if (!validateInput(words)) return false;
        char[][] matrix = new char[colLength][colLength];
        for(String word : words){
            int col = 0;
            for(char ch : word.toCharArray()){
                matrix[row][col] = ch;
                col+=1; 
            }
            row+=1;
        }
        
        int j=0;
        while(j<colLength){
            for(int i=0;i<matrix.length;i++){
            if(matrix[i][j] != matrix[j][i]) return false;
               
        }
             j++;
        }
        return true;
    }
    
     public boolean validateInput(List<String> words) {
         for(String word : words){
             colLength = Math.max(colLength, word.length());
         }
          if(words.size() != colLength) return false;
         return true;
     }

}
