package linkedList;

public class FindMiddleElementDemo {
	public static void main(String[] args) {
		Node head = new Node(1);
		Node head1 = new Node(2);
		Node head2 = new Node(3);
		Node head3 = new Node(4);
		Node head4 = new Node(5);
		Node head5 = new Node(6);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		FindMiddleElementDemo demo = new FindMiddleElementDemo();
		int middleElement = demo.findMiddleElement(head);
		System.out.println(middleElement);

	}

	public int findMiddleElement(Node head) {
		Node fastRunner = head;
		Node slowRunner = head;

		while (fastRunner != null && fastRunner.next != null) {
			fastRunner = fastRunner.next.next;
			slowRunner = slowRunner.next;
		}
		return (int) slowRunner.data;
	}
}
