package com.accpeted.submissions;

public class IntersectionOfTwoSinglyLL {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lA = findLength(headA);
        int lB = findLength(headB);
        
        while(lB < lA) {
            headA = headA.next;
            lA--;
        }
        
        while(lA < lB) {
            headB = headB.next;
            lB--;
        }
        
        while(headB != null) {
            if(headA == headB) return headA;
            headA = headA.next;
            headB = headB.next;
        }
        
        return null;
    }
    
    public int findLength(ListNode head) {
        int length = 0;
        while(head != null){
            head = head.next;
            length+=1;
        }
        return length;
    }

}
