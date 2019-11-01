package com.accpeted.submissions;

public class RemoveDuplicates2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = head;
		while (curr != null && curr.next != null) {
			if (curr.val == curr.next.val) {
				while (curr.next != null && curr.val == curr.next.val)
					curr.next = curr.next.next;
				prev.next = curr.next;
				curr = prev.next;
			} else {
				prev = curr;
				curr = curr.next;
			}
		}
		return dummy.next;
	}

}
