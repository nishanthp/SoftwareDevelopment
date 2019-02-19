package com.accpeted.submissions;

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	// Again the corner case is [1]. 
	// Keeping the dummy node is the ANSWER!!.
	int counter=0;
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        removeNthFromEnd1(dummy, n);
        return dummy.next;
    }
    
     public ListNode removeNthFromEnd1(ListNode head, int n) {
       if(head == null) return null;
       ListNode lastNode = removeNthFromEnd1(head.next, n);
       counter++;
       if(n+1 == counter){
           if(head.next != null) {
               //head.val = head.next.val;
               head.next = head.next.next;
           }
       }
         return head;
    }

}
