package Tree;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IncidentEdgeDemo {
	public static void main(String[] args) {
		GraphNode a = new GraphNode(10);
		GraphNode b = new GraphNode(11);
		GraphNode c = new GraphNode(12);
		GraphNode d = new GraphNode(13);
		a.addAdjacentNodes(d);
		b.addAdjacentNodes(a);
		c.addAdjacentNodes(a);
		d.addAdjacentNodes(c);
		d.addAdjacentNodes(b);

		for (GraphNode eachnode : traverseGraph(a)) {
			System.out.println(eachnode.data);
		}
	}

	public static ArrayList<GraphNode> traverseGraph(GraphNode node) {
		java.util.Deque<GraphNode> queue = new LinkedList<>();
		ArrayList<GraphNode> results = new ArrayList<>();
		queue.add(node);
		node.isVisited = true;
		while (!queue.isEmpty()) {
			GraphNode firstNode = queue.removeFirst();
			if (firstNode == node) {
				results.addAll(firstNode.adjacentNodes);
			}
			for (GraphNode eachnode : firstNode.adjacentNodes) {
				if (!eachnode.isVisited) {
					eachnode.isVisited = true;
					queue.add(eachnode);
				}
				if (eachnode == node) {
					results.add(firstNode);

				}
			}
		}
		return results;
	}
}
