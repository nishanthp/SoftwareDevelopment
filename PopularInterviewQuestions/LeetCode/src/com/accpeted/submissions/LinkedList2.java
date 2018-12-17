package com.accpeted.submissions;

//Corner case [1,2,1]
public class LinkedList2 {
	public static void main(String[] args) {
		// Ran on leetcode.
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		boolean hasCycle = false;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}
		if (!hasCycle)
			return null;

		fast = head;

		while (slow != null && fast != null) {
			if (slow == fast)
				return slow;
			slow = slow.next;
			fast = fast.next;
		}

		return null;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
