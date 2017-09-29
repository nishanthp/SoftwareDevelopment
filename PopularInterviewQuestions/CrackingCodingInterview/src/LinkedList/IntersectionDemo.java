package LinkedList;

import java.util.Stack;

public class IntersectionDemo {
	static Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {
		Node<String> head = new Node<String>("n");
		Node<String> head1 = new Node<String>("i");
		Node<String> head2 = new Node<String>("t");
		Node<String> head3 = new Node<String>("i");
		// Node<String> head4 = new Node<String>("n");
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = null;
		// head4.next = null;
		System.out.println(findPalindrome(head));
	}

	private static boolean findPalindrome(Node<String> head) {
		if (head == null) {
			return false;
		}
		Node<String> slow = head;
		Node<String> fast = head;

		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}

		// even number of elements.
		if (fast != null && fast.next == null) {
			slow = slow.next;
		}

		while (slow != null) {
			if (!(slow.data.equals(stack.pop()))) {
				return false;
			}
			slow = slow.next;
		}
		return true;
	}
}
