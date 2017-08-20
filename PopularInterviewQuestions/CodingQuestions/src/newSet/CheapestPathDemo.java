package newSet;

import java.util.Currency;
import java.util.Stack;

public class CheapestPathDemo {
	static int cheapNodePath = Integer.MAX_VALUE;

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
		// System.out.println(findCheapestPath(n1, 0));
		System.out.println(findCheapestPath_bottomUp(n1));
	}

	private static int findCheapestPath_bottomUp(GraphNode rootNode) {
		if (rootNode.getNeighbors().isEmpty()) {
			return rootNode.getData();
		}

		int min = Integer.MAX_VALUE;
		for (GraphNode children : rootNode.getNeighbors()) {
			int currentCost = findCheapestPath_bottomUp(children);
			if (min > currentCost) {
				min = currentCost;
			}
		}
		return rootNode.getData() + min;

	}

	private static int findCheapestPath(GraphNode rootNode, int currentCost) {
		if (rootNode == null) {
			return 0;
		}
		currentCost += rootNode.getData();
		if (rootNode.getNeighbors().isEmpty()) {
			if (cheapNodePath > currentCost) {
				cheapNodePath = currentCost;
			}
			return cheapNodePath;
		}

		for (GraphNode eachNode : rootNode.getNeighbors()) {
			findCheapestPath(eachNode, currentCost);
		}
		return cheapNodePath;
	}

}
