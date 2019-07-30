package com.accpeted.submissions;

public class GameOfLife {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public void gameOfLife(int[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int[][] dir =  {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int aliveNeighbors = 0;
                for(int[] eachD : dir){
                    int nx = i + eachD[0];
                    int ny = j + eachD[1];
                    if(nx < 0 || ny < 0 || nx >= board.length || ny >= board[0].length) continue;
                    if(board[nx][ny] == 1 || board[nx][ny] == 2) aliveNeighbors +=1;
                }
                if(board[i][j] == 1 && (aliveNeighbors < 2 || aliveNeighbors > 3)) board[i][j] = 2;
                else if (board[i][j] == 0 && aliveNeighbors == 3) board[i][j] = 3;
            }
        }
        
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                board[i][j] %= 2;
            }
        }
    }

}
