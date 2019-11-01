package com.accpeted.submissions;

public class ReOrderList {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public void reorderList(ListNode head) {
		if (head == null)
			return;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode reverseHead = reverse(slow.next);
		slow.next = null;
		ListNode currHead = head;
		while (reverseHead != null) {
			ListNode firstNext = currHead.next;
			ListNode secondNext = reverseHead.next;
			currHead.next = reverseHead;
			reverseHead.next = firstNext;
			currHead = firstNext;
			reverseHead = secondNext;
		}
		return;
	}
	public ListNode reverse(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
