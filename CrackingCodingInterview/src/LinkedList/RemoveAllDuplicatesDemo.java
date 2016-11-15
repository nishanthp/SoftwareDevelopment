package LinkedList;

import java.util.HashMap;

public class RemoveAllDuplicatesDemo {
	HashMap<Integer, Node> map = new HashMap<>();

	public static void main(String[] args) {
		Node head = new Node(10);
		Node head1 = new Node(20);
		Node head2 = new Node(10);
		Node head3 = new Node(20);
		Node head4 = new Node(30);
		Node head5 = new Node(40);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		RemoveAllDuplicatesDemo duplicate = new RemoveAllDuplicatesDemo();
		duplicate.removeAllDuplicates(head);

		// print the linked list.
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	public void removeAllDuplicates(Node head) {
		Node current = head;
		Node previous = head;
		while (current != null) {
			if (map.containsKey(current.data)) {
				previous.next = current.next;
				current = current.next;
			} else {
				map.put(current.data, current);
				previous = current;
				current = current.next;
			}

		}
	}
}
