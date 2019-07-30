package com.accpeted.submissions;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class ShuffleArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
class Solution {
	int[] originalNums;
    Random r;
    public Solution(int[] nums) {
        this.originalNums = nums;
        r = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return this.originalNums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = Arrays.copyOf(this.originalNums, this.originalNums.length);
        for(int i=0;i<this.originalNums.length;i++){
            int randomIndex = this.r.nextInt(this.originalNums.length);
            // swap.
            swap(result, randomIndex , i);
        }
        return result;
    }
    
    private void swap(int[] originalArray, int randomIndex , int i) {
        int temp = originalArray[randomIndex];
        originalArray[randomIndex] = originalArray[i];
        originalArray[i] = temp;
    }
}
}
