package accpetedSubmissions;

public class FindMinRotatedSArray {
public static void main(String []args){
	//Ran on leetcode.
}

public int findMin(int[] nums) {   
    return findUnsortedPart(nums, 0 , nums.length-1);
     
 }
 
 public int findUnsortedPart(int[] nums, int left, int right){
     if(left > right) return -1;
     if(left == right) return nums[left];
     int mid = (left + right)/2;
     if(nums[mid] > nums[right]) {
         return findUnsortedPart(nums, mid+1, right);
     }
     else {
         return findUnsortedPart(nums, left, mid);
     }
 }
}
