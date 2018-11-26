package com.accpeted.submissions;

public class SudokoSolver {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	 public void solveSudoku(char[][] board) {
	        if(board.length == 0 || board == null) return;
	         dfs(board);
	    }
	    
	    public boolean dfs(char[][] board){
	        for(int i=0;i<board.length;i++){
	            for(int j=0; j<board[0].length;j++){
	                if(board[i][j]=='.'){
	                    for(char ch='1';ch<='9';ch++){                  
	                        if (validateEntry(board, i, j, ch)){
	                            board[i][j] = ch;
	                            if (dfs(board)) return true;
	                            else board[i][j] = '.';
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        return true;
	    }
	        
	    public boolean validateEntry(char [][]board, int i, int j, char val){
	        int lowi = (i/3) * 3;
	        int lowj = (j/3) * 3;
	        for(int k=0;k<9;k++){
	            if (board[k][j] != '.' && board[k][j] == val) return false;
	            if (board[i][k] != '.' && board[i][k] == val) return false;
	            if (board[lowi + k/3][lowj + k%3] != '.' && board[lowi + k/3][lowj + k%3] == val) return false;        
	        }
	    return true;
	}
	        
	    }


