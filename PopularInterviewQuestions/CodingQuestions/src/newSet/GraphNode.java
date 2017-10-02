package newSet;

import java.util.ArrayList;

public class GraphNode {
	ArrayList<GraphNode> adjList = new ArrayList<>();

	int data;
	boolean isVisited = Boolean.FALSE;

	State state;

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

	public void setState(State state) {
		this.state = state;
	}

	public State getState() {
		return this.state;
	}
}

enum State {
	UNVISITED, VISITING, VISITED

}