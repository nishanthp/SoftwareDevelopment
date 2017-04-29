package LinkedList;

import java.util.ArrayList;
import java.util.Stack;

public class LinkedListPalindromeDemo {
	ArrayList<String> data = new ArrayList<>();

	public static void main(String[] args) {
		LNode head = new LNode("N");
		LNode head1 = new LNode("I");
		LNode head2 = new LNode("S");
		LNode head3 = new LNode("S");
		LNode head4 = new LNode("N");
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;

		LinkedListPalindromeDemo palindrome = new LinkedListPalindromeDemo();
		// palindrome.checkifPalindrome(head);
		palindrome.checkifPalindromeStack(head);
	}

	public void checkifPalindrome(LNode head) {
		LNode fastRunner = head;
		LNode slowRunner = head;
		while (fastRunner != null && fastRunner.next != null) {
			fastRunner = fastRunner.next.next;
			data.add(slowRunner.data);
			slowRunner = slowRunner.next;
		}

		// skip the middle element.
		if (fastRunner != null) {
			slowRunner = slowRunner.next;
		}
		while (slowRunner != null) {
			for (int i = data.size() - 1; i >= 0; i--) {
				if (!data.get(i).equals(slowRunner.data)) {
					System.out.println("Not a Palindrome");
					return;
				}
				slowRunner = slowRunner.next;
			}
		}
		System.out.println("It is a palindrome.");
	}

	public void checkifPalindromeStack(LNode head) {
		LNode fastRunner = head;
		LNode slowRunner = head;
		Stack<LNode> stack = new Stack<>();
		while (fastRunner != null && fastRunner.next != null) {
			fastRunner = fastRunner.next.next;
			stack.push(slowRunner);
			slowRunner = slowRunner.next;
		}

		// skip the middle element if the number of elements are odd.
		if (fastRunner != null) {
			slowRunner = slowRunner.next;
		}
		while (slowRunner != null) {
			if (!stack.pop().data.equals(slowRunner.data)) {
				System.out.println("Not a Palindrome");
				return;
			}
			slowRunner = slowRunner.next;

		}
		System.out.println("It is a palindrome.");
	}
}

class LNode {
	String data;
	LNode next;

	public LNode(String name) {
		this.data = name;
	}
}
