package MSFT;

public class ReverseDLLDemo {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node head1 = new Node(2);
		Node head2 = new Node(3);

		head.prev = null;
		head.next = head1;

		head1.prev = head;
		head1.next = head2;

		head2.prev = head1;
		head2.next = null;

		Node res = reverseDoubleLL(head);
		while (res != null) {
			System.out.println(res.data);
			res = res.next;
		}
	}

	// this is with updating the pointers
	private static Node reverseDoubleLL(Node head) {
		if (head == null)
			return null;
		Node current = head;
		Node temp = null;
		while (current != null) {
			temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		// this is the most important part.
		if (head != null) {
			head = temp.prev;
		}
		return head;
	}
}

class Node {
	Node prev;
	Node next;
	int data;

	Node(int data) {
		this.data = data;
	}
}