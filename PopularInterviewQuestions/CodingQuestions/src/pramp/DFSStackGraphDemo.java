package pramp;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class DFSStackGraphDemo {
	public static void main(String[] args) {
		GraphNode root = new GraphNode(4);
		GraphNode root4 = new GraphNode(5);
		GraphNode root41 = new GraphNode(6);
		GraphNode root42 = new GraphNode(7);

		root.addNeightbors(root4);
		root.addNeightbors(root41);
		root.addNeightbors(root42);

		GraphNode root5 = new GraphNode(8);
		GraphNode root51 = new GraphNode(9);

		root42.addNeightbors(root5);
		root42.addNeightbors(root51);

		dfsOnGraph(root);
		bfsOnGraph(root);
	}

	private static void bfsOnGraph(GraphNode root) {
		Deque<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(root);
		root.isVisited = true;
		while (!queue.isEmpty()) {
			GraphNode temp = queue.removeFirst();
			System.out.println(temp.data);
			for (GraphNode n : temp.getNeighbors()) {
				if (n.isVisited) {
					continue;
				} else {
					n.isVisited = true;
					queue.add(n);
				}
			}

		}

	}
	
	/**
	 * DFS without recursion and using stack on a graph. This is same as BFS, use stack instead of queue.
	 * @param root
	 */
	private static void dfsOnGraph(GraphNode root) {
		Stack<GraphNode> stack = new Stack<>();
		stack.push(root);
		root.isVisited = true;
		while (!stack.isEmpty()) {
			GraphNode temp = stack.pop();
			System.out.println(temp.data);
			for (GraphNode node : temp.getNeighbors()) {
				if (node.isVisited) {
					continue;
				} else {
					node.isVisited = true;
					stack.push(node);
				}
			}
		}
	}
}
