package com.accpeted.submissions;

public class FlattenDLL {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public Node12 flatten(Node12 head) {
        Node12 dummy = new Node12();
        dummy.next = head;
        while(head != null) {
            System.out.println(head.val);
            if(head.child != null) {
                Node12 childHead = head.child;
                while(childHead.next != null){
                    childHead = childHead.next;
                }
                childHead.next = head.next;
                if(head.next != null) head.next.prev = childHead;
                head.next = head.child;
                head.next.prev = head;
                head.child = null;
            } else {
                head = head.next;
            } 
        }
        return dummy.next;
    }

}
class Node12 {
	 public int val;
	    public Node12 prev;
	    public Node12 next;
	    public Node12 child;

	    public Node12() {}

	    public Node12(int _val,Node12 _prev,Node12 _next,Node12 _child) {
	        val = _val;
	        prev = _prev;
	        next = _next;
	        child = _child;
	    }
}
