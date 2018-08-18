package accpetedSubmissions;

import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Same concept without an input array.
	List<List<Integer>> lists = new LinkedList<>();
    List<Integer> list = new LinkedList<Integer>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combinationSum(n, k, 1);
        return lists;
    }
    
     public void combinationSum (int remainingSum, int k, int start){
         if(list.size() > k || remainingSum < 0) return;
         if (remainingSum == 0 && list.size() == k) {
             list.sort(null);
             if(!lists.contains(list)){
                 List<Integer> tempList = new LinkedList<Integer>();
                 tempList.addAll(list);
                 lists.add(tempList);
             }
             return;
         }

         for(int i=start; i<=9; i++){    
                list.add(i);
                combinationSum(remainingSum-i, k, i+1);
                list.remove(list.size()-1);
            
         }
     }

}
