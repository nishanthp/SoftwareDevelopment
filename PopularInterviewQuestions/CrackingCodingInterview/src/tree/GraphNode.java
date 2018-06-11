package tree;

import java.util.ArrayList;

public class GraphNode {
	int data;
	Boolean isVisited = false;
	ArrayList<GraphNode> adjacentNodes = new ArrayList<>();

	public GraphNode(int d) {
		this.data = d;
	}

	public void addAdjacentNodes(GraphNode adjacentNode) {
		adjacentNodes.add(adjacentNode);
	}

}
