package newSet;

import java.util.ArrayList;

public class GraphNode {
	ArrayList<GraphNode> adjList = new ArrayList<>();

	int data;
	boolean isVisited = Boolean.FALSE;

	public GraphNode(int inp) {
		this.data = inp;
	}

	public void addNeightbors(GraphNode node) {
		this.adjList.add(node);
	}

	public ArrayList<GraphNode> getNeighbors() {
		return this.adjList;
	}

	public boolean isVistesd() {
		return this.isVisited;
	}

	public int getData() {
		return this.data;
	}
}
