package Tree;
import java.util.Stack;

public class BSTIteratorDemo {
	public static void main(String[] args) {
		Node root = new Node(16);
		Node root1 = new Node(11);
		Node root2 = new Node(15);
		Node root3 = new Node(17);
		Node root4 = new Node(14);
		Node root5 = new Node(21);
		Node root6 = new Node(19);
		root.left = root4;
		root.right = root6;
		root4.left = root1;
		root4.right = root2;
		root6.left = root3;
		root6.right = root5;

		Itr iterator = new Itr(root);
		BSTIteratorDemo demo = new BSTIteratorDemo();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}

class Itr {
	Node root;
	Stack<Node> stack = new Stack<>();

	Itr(Node t) {
		this.root = t;
		while (this.root != null) {
			stack.push(this.root);
			this.root = this.root.left;
		}
	}

	public boolean hasNext() {
		return !stack.isEmpty();

	}

	public int next() {
		Node dataNode = stack.pop();
		int result = dataNode.data;
		if (dataNode != null) {
			dataNode = dataNode.right;
			while (dataNode != null) {
				stack.push(dataNode);
				dataNode = dataNode.left;
			}
		}
		return result;
	}

}