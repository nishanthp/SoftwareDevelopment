package com.accpeted.submissions;

public class OddEvenLL {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public ListNode oddEvenList(ListNode head) {
        if(head == null) return head;
        ListNode evenHead = head;
        ListNode oddHead = head.next;
        ListNode dummyOdd = oddHead;
        while(oddHead != null && oddHead.next != null){ 
            evenHead.next = evenHead.next.next;
            oddHead.next = oddHead.next.next;
            oddHead = oddHead.next;
            evenHead = evenHead.next;
        }
        evenHead.next = dummyOdd;
        return head;
    }

}
