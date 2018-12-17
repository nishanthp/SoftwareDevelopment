package com.accpeted.submissions;

public class LinkedListBST {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	ListNode currentNode;
    public TreeNode sortedListToBST(ListNode head) {
        currentNode = head;
        ListNode runner = head; 
        int size=0;
        while(runner != null){
            runner = runner.next;
            size+=1;
        }
        return createBT(0, size-1);
        
    }

    // constructing the tree from bottom up (using inorder)
    // Usually constructing a tree is preorder. (top down)
    public TreeNode createBT(int start, int end){
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode left = createBT(start, mid-1);
        TreeNode root = new TreeNode(currentNode.val);
        root.left = left;
        //This is the key point. 
        currentNode = currentNode.next;
        TreeNode right = createBT(mid+1, end);
        root.right = right;
        return root;
    }

}
