package com.accpeted.submissions;

public class ContainerWithMostWater {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Similar to trapping rain water.
	public int maxArea(int[] height) {
        int left =0;
        int right = height.length-1;
        int lmax=height[left];
        int rmax=height[right];
        int maxArea=0;
        while(left<right){
            lmax = Math.max(lmax, height[left]);
            rmax = Math.max(rmax, height[right]);
            int currMaxArea = (right-left) * Math.min(lmax, rmax);
            maxArea = Math.max(maxArea, currMaxArea);
            
            if(height[left] <= height[right]) left++;
            else right--;
            
          
            
        }
        return maxArea;
    }

}
