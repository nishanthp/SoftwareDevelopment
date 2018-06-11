package linkedList;

public class FindKthToLastElementDemo {
	public static void main(String[] args) {
		Node head = new Node(10);
		Node h2 = new Node(11);
		Node h3 = new Node(12);
		Node h4 = new Node(13);
		Node h5 = new Node(14);
		Node h6 = new Node(15);
		Node h7 = new Node(16);
		head.next = h2;
		h2.next = h3;
		h3.next = h4;
		h4.next = h5;
		h5.next = h6;
		h6.next = h7;
		// kth element.
		int k = 3;
		findKthtoLastElement(head, k, 0);
	}

	private static void findKthtoLastElement(Node head, int k, int count) {
		if (head == null) {
			return;
		}
		findKthtoLastElement(head.next, k, count + 1);
		if (count >= k) {
			System.out.println(head.data);
		}
	}
}
