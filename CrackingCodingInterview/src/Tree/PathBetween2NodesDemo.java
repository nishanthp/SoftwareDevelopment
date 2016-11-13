package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class PathBetween2NodesDemo {
	public static void main(String[] args) {
		GraphNode root = new GraphNode(10);
		PathBetween2NodesDemo path = new PathBetween2NodesDemo();
		path.pathBetweenNodes(root, 21, 33);
	}

	public Boolean pathBetweenNodes(GraphNode root, int data1, int data2) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			GraphNode tempNode = queue.remove();
			if (tempNode.data == data2) {
				return true;
			}
			for (GraphNode adjacent : tempNode.adjacentNodes) {
				if (adjacent.isVisited == false) {
					queue.add(adjacent);
				}
			}
		}
		return null;
	}
}
