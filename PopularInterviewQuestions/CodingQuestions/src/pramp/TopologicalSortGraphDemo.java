package pramp;

import java.util.ArrayList;
import java.util.Stack;

// Retry this using a stack instead of recursion for dfs.
public class TopologicalSortGraphDemo {
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode((int) 'f');
		GraphNode n2 = new GraphNode((int) 'c');
		GraphNode n3 = new GraphNode((int) 'b');
		GraphNode n4 = new GraphNode((int) 'a');
		GraphNode n5 = new GraphNode((int) 'h');
		GraphNode n6 = new GraphNode((int) 'e');
		GraphNode n7 = new GraphNode((int) 'd');
		GraphNode n8 = new GraphNode((int) 'g');

		n1.addNeightbors(n2);
		n1.addNeightbors(n3);
		n1.addNeightbors(n4);

		n2.addNeightbors(n4);

		n3.addNeightbors(n4);
		n3.addNeightbors(n5);
		n3.addNeightbors(n6);

		n4.addNeightbors(n6);

		n7.addNeightbors(n8);

		ArrayList<GraphNode> graphNodes = new ArrayList<>();
		graphNodes.add(n1);
		graphNodes.add(n2);
		graphNodes.add(n3);
		graphNodes.add(n4);
		graphNodes.add(n5);
		graphNodes.add(n6);
		graphNodes.add(n7);
		graphNodes.add(n8);

		// set all the states to unvisited.
		for (GraphNode node : graphNodes) {
			node.setState(State.UNVISITED);
		}
		Stack<GraphNode> buildOrder = new Stack<GraphNode>();
		for (GraphNode node : graphNodes) {
			if (node.getState() == State.UNVISITED) {
				dfs(node, buildOrder);
			}
		}

		while (!buildOrder.isEmpty()) {
			System.out.println((char) buildOrder.pop().data);
		}

	}

	private static boolean dfs(GraphNode node, Stack<GraphNode> buildOrder) {
		if (node.getState() == State.VISITING) {
			return false;
		}
		if (node.getState() == State.UNVISITED) {
			node.setState(State.VISITING);
			for (GraphNode neighbor : node.getNeighbors()) {
				if (!dfs(neighbor, buildOrder)) {
					return false;
				}
			}

			node.setState(State.VISITED);
			buildOrder.push(node);
		}
		return true;
	}

}
