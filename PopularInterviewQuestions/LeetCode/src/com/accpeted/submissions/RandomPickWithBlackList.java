package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class RandomPickWithBlackList {

	public static void main(String[] args) {
		// Ran on leetcode.
		Queue<String> q =  new LinkedList<String>();
		String s= "ff,ewe";
		q.addAll(Arrays.asList(s));
	}
	class Solution {
	HashMap<Integer, Integer> remapping;
    int maxNumber;
    int newSize;
    Random r;
    public Solution(int N, int[] blacklist) {
        this.remapping = new HashMap<Integer, Integer>();
        this.maxNumber = N;
        r = new Random();
        for(int num : blacklist){
            remapping.putIfAbsent(num, -1);
        }
        this.newSize = this.maxNumber - this.remapping.size();
        for(int num : blacklist){
            if(num < this.newSize) {
                while(this.remapping.containsKey(this.maxNumber-1)) this.maxNumber--;
                this.remapping.put(num, this.maxNumber-1);
                this.maxNumber--;
            }
        }
        this.maxNumber = N;
    }
    
    public int pick() {
        int randomIndex = r.nextInt(this.newSize);
        if(this.remapping.containsKey(randomIndex)) return this.remapping.get(randomIndex);
        return randomIndex;
    }

}
}
