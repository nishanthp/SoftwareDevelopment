package accpetedSubmissions;

import java.util.LinkedList;
import java.util.List;

public class Permutation2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	List<List<Integer>> lists = new LinkedList<>();
    List<Integer> list = new LinkedList<Integer>();
    public List<List<Integer>> permuteUnique(int[] nums) {
         boolean[] used = new boolean[nums.length];
         permuteA(nums, used);
         return lists;
    }
    
    ////Permutations with duplicates.
    public void permuteA(int[] nums, boolean[] used){
        if(list.size() > nums.length) return;
        if(list.size() == nums.length){
            if(!lists.contains(list)){
                List<Integer> tempList = new LinkedList<Integer>();
                tempList.addAll(list);
                lists.add(tempList);
            }
        }

        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            list.add(nums[i]);
            used[i] = true;
            permuteA(nums, used);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }

}
