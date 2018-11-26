package com.accpeted.submissions;

public class KthLargestElement {

	public static void main(String[] args) {
		// Ran on leetcode. TC O(n^2) - bad pivot, avg O(n).
		int [] nums = {3,2,1,5,6,4};
		int k=1;
		findKthLargest(nums, k);
	}

	public static int findKthLargest(int[] nums, int k) {
        int kthSmallest = nums.length-k;
        return quickSelect(nums, 0, nums.length-1, kthSmallest);
    }
	
	// Easier solution.
	 public static int quickSelect(int []nums, int low, int high, int k){
	        if(low > high) return Integer.MAX_VALUE;
	        
	        int pivot = nums[high];
	        int left = low;
	        
	        for(int i=low; i<high;i++){
	            if(nums[i] <= pivot){
	                swap(nums, i, left++);
	            }
	        }
	        // place the pivot in the right place.
	        swap(nums, left, high);
	        if(left == k) return nums[left];
	        else if (left < k) return quickSelect(nums, left+1, high,k);
	        else return quickSelect(nums,low,left-1,k);
	        
	        
	    }
    
    
//    public static int quickSelect(int []nums, int low, int high, int k){
//        int i = low;
//        int j = high;
//        int pivot= nums[high];
//        while(i<j){
//            if(nums[i++]>pivot){
//                swap(nums, --i, --j);
//            }
//        }  
//        swap(nums, i, high);      
//        //count
//        int count = i - low + 1;
//        if(count == k) return nums[i];
//        else if(count < k) return quickSelect(nums, i+1, high, k-count);
//        else return quickSelect(nums,low, i-1, k);
//    }
//    
    
    public static  void swap(int []nums, int i, int j){
//    	System.out.println(i);
//    	System.out.println(j);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
