package newSet;

import java.util.LinkedList;
import java.util.Queue;

public class MinEdgesBetVerticesDemo {
	static int count = Integer.MAX_VALUE;

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
		d.BFS(n2, n6);
		System.out.println(count);
	}

	public void BFS(GraphNode source, GraphNode dest) {
		int currentCount = 0;
		Queue<GraphNode> queue = new LinkedList<>();
		queue.add(source);
		source.isVisited = true;
		while (!queue.isEmpty()) {
			for (GraphNode eachNeigbor : queue.poll().getNeighbors()) {
				if (!eachNeigbor.isVisited) {
					System.out.println(eachNeigbor.data);
					queue.add(eachNeigbor);
					eachNeigbor.isVisited = true;
					currentCount += 1;
					if (eachNeigbor.data == dest.data) {
						if (currentCount < count) {
							count = currentCount;
						}
						currentCount = 0;
					}
				}
			}
		}

	}
}
