package com.practice.linkedList;

public class ReverseInGroupKdemo {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node head1 = new Node(2);
		Node head2 = new Node(3);
		Node head3 = new Node(4);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		Node new_head = reverseLL(head, 2);
		while (new_head != null) {
			System.out.println(new_head.next.data);
			new_head = new_head.next;
		}
	}

	private static Node reverseLL(Node head, int k) {
		if (head == null) {
			return null;
		}
		int count = 0;
		Node current = head;
		Node next = null;
		Node prev = null;
		while (count < k && current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count += 1;
		}
		if (next != null) {
			reverseLL(next, k);
		}
		return prev;
	}
}
