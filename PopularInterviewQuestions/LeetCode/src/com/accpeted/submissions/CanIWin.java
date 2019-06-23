package com.accpeted.submissions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CanIWin {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean [] used = new boolean[maxChoosableInteger+1];
        int maxSum =  (maxChoosableInteger*(maxChoosableInteger+1))/2;
        if(maxSum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        
        return canWin(maxChoosableInteger, desiredTotal,used, new HashMap<String, Boolean>());
    }
    
    public boolean canWin(int maxChoosableInteger, int desiredTotal, boolean [] used, HashMap<String, Boolean> map){
        if(desiredTotal<=0) return false;
        // Below is used for memonization.
        String stringRep = Arrays.toString(used);
        if (map.containsKey(stringRep)) return map.get(stringRep);
       
        for(int i=1;i<used.length;i++){   
            if (!used[i]){
            used[i] = true;   
            if (!canWin(maxChoosableInteger, desiredTotal-i, used, map)){
                    map.put(stringRep, Boolean.TRUE);
                    used[i] = false;
                    return true;
                }
                 used[i] = false; 
            }     
        }
        return false;
    }
}
