package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class ZigZagTraversalDemo {
	public static void main(String[] args) {
	}

	public void zigZag(GraphNode root) {

		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(root);
		root.isVisited = true;
		while (!queue.isEmpty()) {
			GraphNode temp = queue.remove();
			if (!temp.isVisited) {
				temp.isVisited = true;
				for (GraphNode neighbour : temp.adjacentNodes) {
					queue.add(neighbour);
				}
			}
		}
	}
}
