package Tree;

import java.util.ArrayList;
import java.util.HashSet;

public class DFSUndirectedGraphDemo {
	public static void main(String[] args) {
		GraphNode a = new GraphNode(10);
		GraphNode b = new GraphNode(11);
		GraphNode c = new GraphNode(12);
		GraphNode d = new GraphNode(14);
		a.addAdjacentNodes(b);
		b.addAdjacentNodes(a);

		b.addAdjacentNodes(d);
		d.addAdjacentNodes(b);

		c.addAdjacentNodes(d);
		d.addAdjacentNodes(c);

		/*
		 * a.addAdjacentNodes(c); c.addAdjacentNodes(a);
		 */

		ArrayList<GraphNode> nodes = new ArrayList<>();
		nodes.add(a);
		nodes.add(b);
		nodes.add(c);
		nodes.add(d);

		System.out.println(hasCycle(nodes));
	}

	private static boolean hasCycle(ArrayList<GraphNode> nodes) {
		HashSet<GraphNode> visited = new HashSet<>();

		for (GraphNode current : nodes) {
			if (visited.contains(current)) {
				continue;
			}
			if (dfs(visited, current, null)) {
				return true;
			}
		}
		return false;

	}

	private static boolean dfs(HashSet<GraphNode> visited, GraphNode current, GraphNode parent) {
		visited.add(current);
		for (GraphNode n : current.adjacentNodes) {
			if (n == parent) {
				continue;
			}
			if (visited.contains(n)) {
				return true;
			}

			boolean hadCycle = dfs(visited, n, current);
			if (hadCycle) {
				return true;
			}
		}

		return false;
	}

}
