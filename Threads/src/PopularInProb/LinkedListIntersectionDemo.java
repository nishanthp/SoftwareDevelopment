package PopularInProb;

public class LinkedListIntersectionDemo {
	public static void main(String[] args) {
		LNode root1 = new LNode(3);
		LNode root1_1 = new LNode(4);
		LNode root1_2 = new LNode(5);
		LNode root1_3 = new LNode(6);
		LNode root1_4 = new LNode(1);
		root1.next = root1_1;
		root1_1.next = root1_2;
		root1_2.next = root1_3;
		root1_3.next = root1_4;
		root1_4.next = null;

		LNode root2 = new LNode(15);
		LNode root2_1 = new LNode(12);
		LNode root2_2 = new LNode(5);
		LNode root2_3 = new LNode(6);
		LNode root2_4 = new LNode(1);
		root2.next = root2_1;
		root2_1.next = root2_2;
		root2_2.next = root2_3;
		root2_3.next = root2_4;
		root2_4.next = null;
		LinkedListIntersectionDemo li = new LinkedListIntersectionDemo();
		li.findTheIntersection(root1, root2);

	}

	public void findTheIntersection(LNode root1, LNode root2) {
		LNode pointOfIntersection = null;
		int length1 = findLength(root1);
		int length2 = findLength(root2);
		int diff = Math.abs(length1 - length2);
		if (length1 > length2) {
			root1 = advanceRootNode(root1, diff);
		} else if(length2 > length1) {
			root2 = advanceRootNode(root2, diff);
		}
		while (root1 != null && root2 != null) {
			if (root1.data == root2.data) {
				pointOfIntersection = root1;
				break;
			}
			root1 = root1.next;
			root2 = root2.next;

		}
		if (pointOfIntersection != null) {
			System.out.println(pointOfIntersection.data);
		} else {
			System.out.println("There is not point of intersection");
		}

	}

	private LNode advanceRootNode(LNode root1, int diff) {
		for (int i = 0; i <= diff; i++) {
			root1 = root1.next;
		}
		return root1;
	}

	private int findLength(LNode root) {
		LNode current = root;
		int counter = 0;
		while (current != null) {
			current = current.next;
			counter++;
		}
		return counter;
	}
}

class LNode {
	LNode next;
	int data;

	public LNode(int d) {
		this.data = d;
	}
}
