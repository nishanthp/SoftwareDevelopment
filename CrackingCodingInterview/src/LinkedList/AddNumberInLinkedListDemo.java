package LinkedList;

public class AddNumberInLinkedListDemo {
	int carry = 0;

	public static void main(String[] args) {
		// First Number.
		Node head1 = new Node(6);
		Node head11 = new Node(1);
		Node head12 = new Node(7);
		head1.next = head11;
		head11.next = head12;

		// Second Number.
		Node head2 = new Node(2);
		Node head21 = new Node(9);
		Node head22 = new Node(5);
		head2.next = head21;
		head21.next = head22;
		AddNumberInLinkedListDemo demo = new AddNumberInLinkedListDemo();
		Node resultHead = demo.addNumbers(head1, head2);

		// print
		while (resultHead != null) {
			System.out.println(resultHead.data);
			resultHead = resultHead.next;
		}

	}

	public Node addNumbers(Node h1, Node h2) {
		if (h1 == null && h2 == null) {
			return null;
		}
		Node result = addNumbers(h1.next, h2.next);
		int resultant = h1.data + h2.data + carry;
		carry = resultant / 10;
		Node temp = new Node(resultant % 10);
		temp.next = result;
		return temp;
	}
}
