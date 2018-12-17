package com.accpeted.submissions;

import java.util.HashMap;
import java.util.HashSet;

public class CanIWin {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
HashSet<Integer> set = new HashSet<Integer>();
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        boolean [] used = new boolean[maxChoosableInteger+1];
        // important optimization. (n)*(n+1)/2
        int maxSum =  (maxChoosableInteger*(maxChoosableInteger+1))/2;
        if(maxSum < desiredTotal) return false;
        if(desiredTotal <= 0) return true;
        // hashmap used for memonization, else time limit will be exceeded. 
        return canWin(maxChoosableInteger, desiredTotal,used, new HashMap<Integer, Boolean>());
    }
    
    // Same as recursive backtracking,similar to flip win game.
    public boolean canWin(int maxChoosableInteger, int desiredTotal, boolean [] used, HashMap<Integer, Boolean> map){
        if(desiredTotal<=0) return false;
        int key = format(used);
        if (map.containsKey(key)) return map.get(key);
       
        for(int i=1;i<used.length;i++){   
            if (!used[i]){
            used[i] = true;   
            if (!canWin(maxChoosableInteger, desiredTotal-i, used, map)){
                    map.put(key, true);
                    used[i] = false;
                    return true;
                }
             used[i] = false;
            
            }     
        }
        map.put(key, false);
        return false;
    }
    
    public int format(boolean[] input){
        int i=0;
        for(boolean in : input){
            i <<=1;
            if(in) i |=1;
        }
        return i;
    }

}
