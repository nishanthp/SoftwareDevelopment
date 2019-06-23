package com.accpeted.submissions;

public class nextRightPointerEachNode {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public Node connect(Node root) {
        Node pre = root;
        Node dummyNode = new Node();
        Node prev = dummyNode;
        while(root != null){
            if(root.left != null) {
                prev.next = root.left;
                prev = prev.next;
            }
            if(root.right != null) {
                prev.next = root.right;
                prev = prev.next;
            }
            root = root.next;
            // Below is the important part.
            if(root == null) { 
                prev = dummyNode;
                root = dummyNode.next;
                dummyNode.next = null;
            }
        }
        return pre;
    
    }
	
	class Node {	
		int val;
		Node left;
		Node right;
		Node next;
			
	}

}
