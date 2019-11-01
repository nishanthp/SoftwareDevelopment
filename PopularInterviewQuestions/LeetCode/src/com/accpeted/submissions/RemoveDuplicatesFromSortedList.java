package com.accpeted.submissions;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public ListNode deleteDuplicates(ListNode head) {
		if (head == null)
			return null;
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode curr = head;
		while (curr.next != null) {
			if (curr.val == curr.next.val)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		return dummy.next;
	}

}
