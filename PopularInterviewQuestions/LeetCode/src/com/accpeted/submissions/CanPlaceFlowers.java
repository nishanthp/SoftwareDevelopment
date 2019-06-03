package com.accpeted.submissions;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(n==0 || flowerbed.length == 0) return true;
        for(int i=0;i<flowerbed.length;i++){
            if(n==0) return true;
            if(flowerbed[i] == 0 &&  checkNeighbors(flowerbed, i)) {
                flowerbed[i] = 1;
                n--;
            }
    }
        return n==0 ? true : false;
    }
    
     public boolean checkNeighbors(int[] flowerbed, int i) {
         if(flowerbed.length==1) return true;
         int left = i-1;
         int right = i+1;
         if(left < 0 && right <= flowerbed.length-1) {
             if (flowerbed[right] == 1) return false;
             return true;
         } 
         if (right > flowerbed.length-1 && left > 0) {
             if (flowerbed[left] == 1) return false;
             return true;
         } 
         if(flowerbed[left] == 1 || flowerbed[right] == 1) return false;
         return true;
     }

}
