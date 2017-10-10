package pramp;

public class FlattenLinkedListDemo {
	public static void main(String[] args) {
		LNode head = new LNode(5);
		LNode n1 = new LNode(10);
		LNode n2 = new LNode(19);
		LNode n3 = new LNode(28);
		LNode n4 = new LNode(7);
		LNode n5 = new LNode(20);
		LNode n6 = new LNode(22);
		LNode n7 = new LNode(35);
		LNode n8 = new LNode(8);
		LNode n9 = new LNode(50);
		LNode n10 = new LNode(40);
		LNode n11 = new LNode(30);
		LNode n12 = new LNode(45);

		head.down = n4;
		n4.down = n8;
		n8.down = n11;

		head.right = n1;
		n1.down = n5;

		n1.right = n2;
		n2.down = n6;
		n6.down = n9;

		n2.right = n3;
		n3.down = n7;
		n7.down = n10;
		n10.down = n12;

		FlattenLinkedListDemo flatten = new FlattenLinkedListDemo();
		LNode newhead = flatten.flatten(head);

		while (head != null) {
			System.out.println(head.data);
			head = head.down;
		}
	}

	public LNode flatten(LNode head) {
		if (head == null || head.right == null) {
			return head;
		}
		head.right = flatten(head.right);
		head = merge(head, head.right);
		return head;
	}

	private LNode merge(LNode a, LNode b) {
		if (a == null)
			return b;
		if (b == null)
			return a;
		LNode result = null;
		if (a.data < b.data) {
			result = a;
			result.down = merge(a.down, b);
		} else {
			result = b;
			result.down = merge(a, b.down);
		}
		return result;
	}
}

class LNode {
	LNode right;
	LNode down;
	int data;

	public LNode(int data) {
		this.data = data;
	}
}
