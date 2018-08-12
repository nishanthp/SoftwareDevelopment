package accpetedSubmissions;

import java.util.LinkedList;
import java.util.List;

public class LeafSimilar {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	 List<Integer> list1 = new LinkedList<Integer>();
     List<Integer> list2 = new LinkedList<Integer>();
 public boolean leafSimilar(TreeNode root1, TreeNode root2) {       
     checkSimilarity(root1, list1);
     checkSimilarity(root2, list2);
     if(list1.size() != list2.size()) return false;
     for(int i=0;i<list1.size();i++){
         if(list2.get(i) != list1.get(i)) return false;
     }
     
     return true;
 }
 
 public TreeNode checkSimilarity (TreeNode root, List<Integer> list){
    if(root == null) return null;
     TreeNode left = checkSimilarity (root.left, list);
     TreeNode right = checkSimilarity (root.right, list);
     if(left == null && right == null) list.add(root.val);
     return root;
     
 }
}
