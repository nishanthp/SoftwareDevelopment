package accpetedSubmissions;

import java.util.LinkedList;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	List<List<Integer>> lists = new LinkedList<>();
    List<Integer> list = new LinkedList<Integer>();
    public List<List<Integer>> permute(int[] nums) {
        permuteA(nums);
        return lists;
    }
    //Permutations without duplicates.
    public void permuteA(int[] nums){
        if(list.size() > nums.length)return;
        if(list.size() == nums.length){
            if(!lists.contains(list)){
                List<Integer> tempList = new LinkedList<Integer>();
                tempList.addAll(list);
                lists.add(tempList);
            }
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            permuteA(nums);
            list.remove(list.size()-1);
        }
    }

}
