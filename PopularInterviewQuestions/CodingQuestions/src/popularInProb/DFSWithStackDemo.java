package popularInProb;

import java.util.Stack;

import javax.swing.plaf.basic.BasicTreeUI.TreeTraverseAction;

public class DFSWithStackDemo {
	static Stack<DFS_Node> nodes = new Stack<>();

	public static void main(String[] args) {
		DFS_Node n1 = new DFS_Node(10);
		DFS_Node n2 = new DFS_Node(12);
		DFS_Node n3 = new DFS_Node(13);
		DFS_Node n4 = new DFS_Node(14);
		DFS_Node n5 = new DFS_Node(6);
		DFS_Node n6 = new DFS_Node(7);
		DFS_Node n7 = new DFS_Node(2);
		n1.left = n2;
		n1.right = n3;
		n2.right = n4;
		n4.left = n5;
		n6.right = n7;
		n3.left = n6;
		traverse(n1);

	}

	public static void traverse(DFS_Node root) {
		if (root == null) {
			return;
		}
		nodes.push(root);
		traverse(root.left);
		DFS_Node currentNode = nodes.pop();
		System.out.println(currentNode.d);
		traverse(root.right);

	}
}

class DFS_Node {
	DFS_Node left;
	DFS_Node right;
	int d;

	public DFS_Node(int data) {
		this.d = data;
	}
}
