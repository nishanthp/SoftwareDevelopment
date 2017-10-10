package pramp;

import java.util.LinkedList;
import java.util.Queue;

public class MinEdgesBetVerticesDemo {

	public static void main(String[] args) {
		GraphNode n1 = new GraphNode(0);
		GraphNode n2 = new GraphNode(1);
		GraphNode n3 = new GraphNode(2);
		GraphNode n4 = new GraphNode(3);
		GraphNode n5 = new GraphNode(4);
		GraphNode n6 = new GraphNode(5);
		GraphNode n7 = new GraphNode(6);

		// 0
		n1.addNeightbors(n5);
		n1.addNeightbors(n3);
		n1.addNeightbors(n2);

		// 1
		n2.addNeightbors(n1);
		n2.addNeightbors(n3);

		// 2
		n3.addNeightbors(n6);
		n3.addNeightbors(n1);
		n3.addNeightbors(n2);

		// 4
		n5.addNeightbors(n1);
		n5.addNeightbors(n7);
		n5.addNeightbors(n4);
		n5.addNeightbors(n6);

		// 5
		n6.addNeightbors(n5);
		n6.addNeightbors(n3);
		MinEdgesBetVerticesDemo d = new MinEdgesBetVerticesDemo();
		int[] distances = new int[7];
		System.out.println(d.BFS(n2, n6, distances));
	}

	public int BFS(GraphNode source, GraphNode dest, int[] distances) {
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(source);
		source.isVisited = true;
		while (!queue.isEmpty()) {
			GraphNode head = queue.remove();
			for (GraphNode eachNeighbor : head.getNeighbors()) {
				if (!eachNeighbor.isVisited) {
					queue.add(eachNeighbor);
					eachNeighbor.isVisited = true;
					int currentData = distances[eachNeighbor.data];
					currentData += distances[head.data] + 1;
					if (distances[eachNeighbor.data] != 0) {
						distances[eachNeighbor.data] = Math.min(distances[eachNeighbor.data], currentData);
					} else {
						distances[eachNeighbor.data] = currentData;
					}
					if (eachNeighbor.data == dest.data) {
						eachNeighbor.isVisited = false;
					}
				}
			}
		}
		return distances[dest.data];
	}
}
