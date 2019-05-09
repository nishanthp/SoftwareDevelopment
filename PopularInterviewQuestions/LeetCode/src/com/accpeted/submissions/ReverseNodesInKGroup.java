package com.accpeted.submissions;

public class ReverseNodesInKGroup {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 1) return head;
        ListNode dummyNode = new ListNode(0); 
        dummyNode.next = head;
        ListNode start = dummyNode;
        int counter = 0;
        while(head != null) {
            counter ++;
            if(counter % k == 0) {
                start = reverse(start, head.next);
                head = start.next;
                
            } else {
                 head = head.next;  
            }  
        }   
        return dummyNode.next;
    }
    
    // Popular question. This is important part. Look into this. Draw it out.
    public ListNode reverse(ListNode start, ListNode end) { 
        ListNode curr = start.next;
        ListNode first = curr;
        ListNode prev = start;
        while(curr != end) {
                ListNode next = curr.next; 
                curr.next = prev;
                prev = curr; 
                curr = next;
        }
        start.next = prev;
        first.next = end;
        return first;
    }
}
