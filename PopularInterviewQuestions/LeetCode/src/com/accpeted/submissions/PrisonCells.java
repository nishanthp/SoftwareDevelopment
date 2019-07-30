package com.accpeted.submissions;

import java.util.HashMap;

public class PrisonCells {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public int[] prisonAfterNDays(int[] cells, int N) {
        HashMap<String, int[]> dp = new HashMap<String, int[]>();
        N = N % 14;
        if(N==0) N = 14;
        return prisonAfterNDaysT(cells, N, dp);  
    }
    
    
     public int[] prisonAfterNDaysT(int[] cells, int N, HashMap<String, int[]> dp) {
        if(N == 0) return cells;
        
        int[] res = new int[8];
        for(int i=0; i<cells.length;i++){
            if(i==0 || i==cells.length-1) {
                if(cells[i] == 1) res[i] = 0;
                    continue;
            }
            if(cells[i-1] == cells[i+1]) res[i] = 1; 
            else res[i] = 0;
        }
    
        cells = res;
        return prisonAfterNDaysT(cells,  N-1, dp);
    }

}
