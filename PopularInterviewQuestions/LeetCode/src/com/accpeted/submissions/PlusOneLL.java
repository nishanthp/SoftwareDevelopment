package com.accpeted.submissions;

public class PlusOneLL {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	int count = 0;
	public ListNode plusOne(ListNode head) {
		count++;
		if (head.next == null) {
			head.val += 1;
		} else {
			head.next = plusOne(head.next);
			if (head.next.val >= 10) {
				head.next.val -= 10;
				head.val += 1;
			}
		}
		count--;
		if (count == 0 && head.val >= 10) {
			ListNode firstNode = new ListNode(1);
			head.val -= 10;
			firstNode.next = head;
			head = firstNode;
		}

		return head;
	}

}
