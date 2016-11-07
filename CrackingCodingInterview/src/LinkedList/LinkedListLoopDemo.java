package LinkedList;

public class LinkedListLoopDemo {
	public static void main(String[] args) {
		Node h = new Node(10);
		Node h1 = new Node(11);
		Node h2 = new Node(12);
		Node h3 = new Node(13);
		Node h4 = new Node(14);
		Node h5 = new Node(15);
		Node h6 = new Node(16);
		h.next = h1;
		h1.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		h5.next = h6;
		// h6.next = h3;

		LinkedListLoopDemo demo = new LinkedListLoopDemo();
		Node loopHead = demo.detectLoop(h);
		if (loopHead != null) {
			System.out.println(loopHead.data);
		} else
			System.out.println("No loop detected in the linked list.");

	}

	public Node detectLoop(Node head) {
		Node fastRunner = head;
		Node slowRunner = head;
		while (fastRunner != null && fastRunner.next != null) {
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
			if (fastRunner == slowRunner) {
				break;
			}
		}
		// no loop in the linked list.
		if (fastRunner != null || fastRunner.next == null) {
			return null;
		}
		// find postion of the loop head
		fastRunner = head;
		while (slowRunner != fastRunner) {
			slowRunner = slowRunner.next;
			fastRunner = fastRunner.next;
		}
		return fastRunner;
	}
}

class Node {
	Node next;
	int data;

	public Node(int d) {
		this.data = d;
	}
}
