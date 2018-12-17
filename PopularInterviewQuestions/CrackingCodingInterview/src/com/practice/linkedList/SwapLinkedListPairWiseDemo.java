package com.practice.linkedList;

public class SwapLinkedListPairWiseDemo {
	public static void main(String[] args) {
		Node h = new Node(1);
		Node h1 = new Node(2);
		Node h2 = new Node(3);
		Node h3 = new Node(4);
		Node h4 = new Node(5);
		Node h5 = new Node(6);
		h.next = h1;
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		SwapLinkedListPairWiseDemo demo = new SwapLinkedListPairWiseDemo();
		// Node head = demo.swapPairWise(h);
		Node head = demo.swapPairWiseData(h);

		// print
		while (head != null) {
			System.out.println("Data" + head.data);
			head = head.next;
		}
	}

	public Node swapPairWise(Node head) {
		int swap = 0;
		Node current = head;
		Node next = head.next;
		Node future = head.next.next;
		while (future != null && future.next != null) {
			next.next = current;
			current.next = future.next;
			swap++;
			// update head node.
			if (swap == 1) {
				head = next;
			}
			current = future;
			next = current.next;
			future = future.next.next;
		}

		if (future != null) {
			next.next = current;
			current.next = future;
		}
		if (future == null) {
			next.next = current;
			current.next = null;
		}
		return head;
	}

	// swap by swapping the data between nodes.
	public Node swapPairWiseData(Node head) {
		Node current = head;
		while (current != null && current.next != null) {
			int temp = (int) current.next.data;
			current.next.data = current.data;
			current.data = temp;
			current = current.next.next;
		}
		return head;
	}
}
