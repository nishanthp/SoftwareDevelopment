package PopularInProb;

import java.util.HashMap;

public class CloneLLWithRandomPointer {
	HashMap<LLNode, LLNode> map = new HashMap<LLNode, LLNode>();

	public static void main(String[] args) {
		LLNode o1 = new LLNode(1);
		LLNode o2 = new LLNode(2);
		LLNode o3 = new LLNode(3);
		o1.next = o2;
		o2.next = o3;
		o1.random = o3;
		o2.random = o1;
		o3.random = o1;
		CloneLLWithRandomPointer p = new CloneLLWithRandomPointer();
		LLNode p1 = p.cloneLinkedListWithRandomPointer(o1);
		p1 = p1.next;
		System.out.println(p1.data);
		System.out.println(p1.next.data);
		System.out.println(p1.random.data);

	}

	public LLNode cloneLinkedListWithRandomPointer(LLNode head) {
		LLNode current = head;
		LLNode newHead = new LLNode(head.data);
		map.put(current, newHead);
		LLNode q = newHead;
		LLNode test = newHead;
		current = current.next;
		while (current != null) {
			LLNode temp = new LLNode(current.data);
			map.put(current, temp);
			newHead.next = temp;
			newHead = temp;
			current = current.next;
		}
		LLNode p = head;
		while (p != null) {
			if (p.random != null) {
				LLNode randomPointerNode = map.get(p.random);
				q.random = randomPointerNode;
			} else {
				q.random = null;
			}
			p = p.next;
			q = q.next;
		}
		return test;

	}
}

class LLNode {
	int data;
	LLNode next;
	LLNode random;

	public LLNode(int d) {
		this.data = d;
	}
}
