package Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class PathBetween2NodesDemo {
	HashMap<Integer, GraphNode> map = new HashMap<>();

	public static void main(String[] args) {
		GraphNode root = new GraphNode(2);
		GraphNode root1 = new GraphNode(3);
		GraphNode root2 = new GraphNode(7);
		GraphNode root3 = new GraphNode(4);
		GraphNode root4 = new GraphNode(5);
		GraphNode root5 = new GraphNode(9);
		GraphNode root6 = new GraphNode(6);

		root.addAdjacentNodes(root1);
		root.addAdjacentNodes(root2);
		root1.addAdjacentNodes(root3);
		root2.addAdjacentNodes(root4);
		root3.addAdjacentNodes(root4);
		root4.addAdjacentNodes(root6);
		PathBetween2NodesDemo path = new PathBetween2NodesDemo();
		path.findPathBetweenNodes(root, root2.data, root6.data);
	}

	public void findPathBetweenNodes(GraphNode root, int startNodeData, int endNodeData) {
		// if start node exists.
		if (pathBetweenNodes(root, startNodeData)) {
			GraphNode startNode = map.get(startNodeData);
			if (startNode != null) {
				if (pathBetweenNodes(startNode, endNodeData)) {
					System.out.println("Path exist between the start node and the end node.");
				} else {
					System.out.println("Path does not exist between the start node and the end node.");
				}
			}
		} else
			System.out.println("Start node does not exists.");
	}

	private Boolean pathBetweenNodes(GraphNode root, int data) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			GraphNode tempNode = queue.remove();
			if (tempNode.data == data) {
				map.put(data, tempNode);
				return true;
			}
			for (GraphNode adjacent : tempNode.adjacentNodes) {
				if (adjacent.isVisited == false) {
					queue.add(adjacent);
				}
			}
		}
		return false;
	}
}
