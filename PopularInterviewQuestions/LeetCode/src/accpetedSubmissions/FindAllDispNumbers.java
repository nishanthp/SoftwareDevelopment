package accpetedSubmissions;

import java.util.LinkedList;
import java.util.List;

public class FindAllDispNumbers {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	// Find the disappeared numbers in constant space except the resultant array.
	public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
     // Idea: Make all the seen numbers duplicate
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index] > 0){
                nums[index] = -nums[index];
            }
        }
        // Iterate again to see which ones are non-negative
        for(int i=0;i<nums.length;i++){
            if(nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
}

}
