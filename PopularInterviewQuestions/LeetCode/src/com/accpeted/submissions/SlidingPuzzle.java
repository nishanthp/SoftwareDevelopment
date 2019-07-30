package com.accpeted.submissions;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class SlidingPuzzle {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	 public int slidingPuzzle(int[][] board) {
	        StringBuilder sb = new StringBuilder();
	        for(int i=0;i<board.length;i++){
	            for(int j=0;j<board[0].length;j++){
	                sb.append(String.valueOf(board[i][j]));
	            }
	        }
	        
	        String currNode = sb.toString();
	        String resNode = "123450";
	        int[][] validMoves = {{-1,0},{1,0},{0,-1},{0,1}};
	        HashSet<String> visited = new HashSet<String>();
	        Deque<String> queue = new LinkedList<String>();
	        queue.add(currNode);
	        visited.add(currNode);
	        int count = 0;
	        while(!queue.isEmpty()){
	            int size = queue.size();
	            for(int i=0;i<size;i++){
	                String curr = queue.poll();
	                if(curr.equals(resNode)) return count;
	                int zeroIndex = curr.indexOf("0");
	                // this the most important point.
	                int cRow = zeroIndex/board[0].length;
	                int cCol = zeroIndex%board[0].length;
	                for(int[] validMove : validMoves){
	                    int r = validMove[0] + cRow;
	                    int c = validMove[1] + cCol;
	                    if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) continue;
	                    String nextNode = swap(curr, zeroIndex, r*board[0].length+c);
	                    if(visited.contains(nextNode)) continue;
	                    visited.add(nextNode);
	                    queue.add(nextNode);
	                }
	            }
	            
	        }
	        
	        return -1;
	    }
	    
	    public String swap (String s, int i, int j){
	        char[] ch = s.toCharArray();
	        char temp = ch[i];
	        ch[i] = ch[j];
	        ch[j] = temp;
	        return new String(ch);
	    }

}
