package com.accpeted.submissions;

public class PartitionList {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        
        while(head != null) {
            if(head.val < x){
              curr1.next = head;
              curr1 = head;
            } else {
              curr2.next = head;
              curr2 = head;
            }
            head = head.next;
        }
        curr1.next = dummy2.next;
        curr2.next = null;
        return dummy1.next;
    }

}
