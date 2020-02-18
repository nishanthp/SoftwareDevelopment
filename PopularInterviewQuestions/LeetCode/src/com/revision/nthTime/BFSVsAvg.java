package com.revision.nthTime;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BFSVsAvg {

	public static void main(String[] args) {
		Node root = new Node(2);
		Node root1 = new Node(1);
		Node root2 = new Node(3);
		Node root3 = new Node(4);

		root.setChildren(root1);
		root.setChildren(root2);
		root.setChildren(root3);

		bfs(root);
	}

	private static void bfs(Node root) {
		Deque<Node> q = new LinkedList<Node>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			Node temp = q.remove();
			int sum = 0;
			for (Node child : temp.children) {
				sum += child.val;
				q.add(child);

			}
			int avg = temp.val / size;
			System.out.println(avg);
		}

	}

}

class Node {
	ArrayList<Node> children;
	int val;
	Node(int val) {
		children = new ArrayList<>();
		this.val = val;
	}
	void setChildren(Node i) {
		children.add(i);
	}

	List<Node> getChildren() {
		return children;
	}

}
