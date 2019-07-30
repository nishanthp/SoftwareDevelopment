package com.accpeted.submissions;

public class RegexMatching {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean isMatch(String s, String p) {
        char [] input = s.toCharArray();
        char [] pattern = p.toCharArray();
        
        boolean [][] matrix = new boolean[input.length+1][pattern.length+1];
        //initial values. Both are empty strings.
        matrix[0][0] = true;
        for (int j=1;j<matrix[0].length; j++) {
        if (p.charAt(j-1) == '*') {
            matrix[0][j] = matrix[0][j-2];
        }
    }

        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(input[i-1] == pattern[j-1] || pattern[j-1] == '.'){
                    matrix[i][j] = matrix[i-1][j-1];
                }else if(pattern[j-1] == '*'){
                    matrix[i][j] = matrix[i][j-2];
                    if(pattern[j-2] == input[i-1] || pattern[j-2] == '.') {
                        matrix[i][j] |= matrix[i-1][j] || matrix[i][j-1];
                    }
                }
            }
        }
        return matrix[input.length][pattern.length];
    }

}
