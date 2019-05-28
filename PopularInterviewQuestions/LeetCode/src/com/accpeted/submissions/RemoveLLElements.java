package com.accpeted.submissions;

public class RemoveLLElements {
public static void main(String []args){
	//Ran on leetcode.
}

// Adding a dummy node in front is the key and moving the curr pointer in the else part. 
public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode curr = dummy;
    while(curr.next != null){
        if(curr.next.val == val){
            curr.next = curr.next.next;
        }else {
            curr = curr.next;  
        }               
    }       
    return dummy.next;
}
}
