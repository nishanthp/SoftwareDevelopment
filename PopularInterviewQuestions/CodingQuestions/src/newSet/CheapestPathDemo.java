package newSet;

import java.util.Currency;

public class CheapestPathDemo {
	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(0);
		GraphNode n2 = new GraphNode(5);
		GraphNode n3 = new GraphNode(3);
		GraphNode n4 = new GraphNode(6);
		GraphNode n5 = new GraphNode(4);
		GraphNode n6 = new GraphNode(2);
		GraphNode n7 = new GraphNode(0);
		GraphNode n8 = new GraphNode(1);
		GraphNode n9 = new GraphNode(5);
		GraphNode n10 = new GraphNode(1);
		GraphNode n11 = new GraphNode(10);
		GraphNode n12 = new GraphNode(1);
		n1.addNeightbors(n2);
		n1.addNeightbors(n3);
		n1.addNeightbors(n4);
		n2.addNeightbors(n5);
		n3.addNeightbors(n6);
		n3.addNeightbors(n7);
		n4.addNeightbors(n8);
		n4.addNeightbors(n9);
		n6.addNeightbors(n10);
		n7.addNeightbors(n11);
		n10.addNeightbors(n12);
		System.out.println(findCheapestPath(n1, Integer.MAX_VALUE));

	}

	private static int findCheapestPath(GraphNode rootNode, int leastPathCost) {
		if (rootNode == null) {
			return 0;
		}

		int currentCost = 0;
		if (rootNode.getNeighbors() != null) {
			// traverse the child nodes.

			for (GraphNode node : rootNode.getNeighbors()) {
				currentCost = node.getData() + findCheapestPath(node, leastPathCost);
				if (currentCost < leastPathCost) {
					leastPathCost = currentCost;
				}
			}

		} else {
			return 0;
		}
		return leastPathCost;
	}
}
