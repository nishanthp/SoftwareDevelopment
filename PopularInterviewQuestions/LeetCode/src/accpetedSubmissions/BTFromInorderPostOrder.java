package accpetedSubmissions;

import java.util.HashMap;

public class BTFromInorderPostOrder {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	// Take an example, write it postorder and inorder array and see the below code.
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        HashMap<Integer,Integer> inOrderMap = new HashMap<Integer,Integer>();
        for(int i=0; i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return buildTree(postorder, inorder, inOrderMap, 0, 0, postorder.length-1, inorder.length-1);
    }
    
public TreeNode buildTree(int[] postorder,int[] inorder,HashMap<Integer, Integer> inOrderMap,int postStart,int inStart,int postEnd,int inEnd) {
        if(postStart > postEnd || inStart > inEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = inOrderMap.get(root.val);
        // in post order its number of right elements, if in-order is given, its number of left elements
        int rightElements = inEnd - rootIndex;
        root.left = buildTree(postorder, inorder, inOrderMap, postStart, inStart, postEnd-rightElements-1, rootIndex -1);
        root.right = buildTree(postorder, inorder, inOrderMap, postStart, rootIndex+1, postEnd-1, inEnd);
        return root;
        
    }

}
