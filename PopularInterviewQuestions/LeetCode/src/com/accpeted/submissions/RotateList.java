package com.accpeted.submissions;

public class RotateList {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        int counter = 0;
        while(right.next != null){
            right = right.next;
            counter +=1;
        }
        int i = counter-k%counter;
        while(i > 0) {
            left = left.next;
            i -=1;
        }
        right.next = dummy.next;
        dummy.next = left.next;
        left.next = null; 
        return dummy.next;
    }

}
