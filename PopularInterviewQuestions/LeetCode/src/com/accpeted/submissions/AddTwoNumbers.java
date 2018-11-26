package com.accpeted.submissions;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// Ran on leetcode.
	}
	
	// Do iteratively. As opposed to recursive solution. (Input numbers are already reversed.)
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        int carry = 0;
	        ListNode resultant = null;
	        ListNode head = null;
	        while(l1 != null && l2 != null){
	            int result = l1.val + l2.val + carry;
	            if(carry == 1) carry = 0 ;
	            if(resultant == null) {
	                resultant = new ListNode(result%10);
	                head = resultant;
	            }else {
	                resultant.next = new ListNode(result%10);
	                resultant = resultant.next;
	            }
	            if(result >= 10) carry = 1;         
	            l1 = l1.next;
	            l2 = l2.next;
	        }
	        while(l1 != null) {
	            int result = l1.val + carry;
	            if (result >= 10) carry = 1;
	            else carry = 0;
	            resultant.next = new ListNode(result%10);
	            resultant = resultant.next;
	            l1 = l1.next;
	        }
	        while(l2 != null) {
	            int result = l2.val + carry;
	            if (result >= 10) carry = 1;
	            else carry = 0;
	            System.out.println(carry);
	            resultant.next = new ListNode(result%10);
	            resultant = resultant.next;
	            l2 = l2.next;
	        }
	        if(carry == 1) resultant.next = new ListNode(carry);
	        return head;
	    }

}
