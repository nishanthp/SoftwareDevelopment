package com.accpeted.submissions;

import java.util.ArrayDeque;
import java.util.Deque;

public class AddTwoNumbers2 {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Deque<Integer> l1Stack = new ArrayDeque<Integer>();
		Deque<Integer> l2Stack = new ArrayDeque<Integer>();

		while (l1 != null) {
			l1Stack.push(l1.val);
			l1 = l1.next;
		}
		while (l2 != null) {
			l2Stack.push(l2.val);
			l2 = l2.next;
		}

		ListNode curr = new ListNode(0);
		while (!l1Stack.isEmpty() || !l2Stack.isEmpty()) {
			int sum = 0;
			if (!l1Stack.isEmpty())
				sum += l1Stack.pop();
			if (!l2Stack.isEmpty())
				sum += l2Stack.pop();
			sum += curr.val;
			curr.val = sum % 10;
			ListNode head = new ListNode(sum / 10);
			System.out.println(head.val);
			head.next = curr;
			curr = head;
		}
		return curr.val == 0 ? curr.next : curr;
	}

}
