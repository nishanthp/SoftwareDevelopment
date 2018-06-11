package tree;

import java.util.HashSet;

public class DFSCycleDemo {
	static HashSet<GraphNode> whiteSet = new HashSet<>();
	static HashSet<GraphNode> blackSet = new HashSet<>();
	static HashSet<GraphNode> greySet = new HashSet<>();

	public static void main(String[] args) {
		GraphNode g1 = new GraphNode(1);
		GraphNode g2 = new GraphNode(2);
		GraphNode g3 = new GraphNode(3);
		GraphNode g4 = new GraphNode(4);
		GraphNode g5 = new GraphNode(5);
		GraphNode g6 = new GraphNode(6);
		g1.addAdjacentNodes(g2);
		g1.addAdjacentNodes(g3);
		g2.addAdjacentNodes(g3);

		g4.addAdjacentNodes(g1);
		g4.addAdjacentNodes(g5);
		g5.addAdjacentNodes(g6);
		g6.addAdjacentNodes(g4);
		whiteSet.add(g1);
		whiteSet.add(g2);
		whiteSet.add(g3);
		whiteSet.add(g4);
		whiteSet.add(g5);
		whiteSet.add(g6);

		System.out.println(hasCycle(whiteSet, blackSet, greySet));
	}

	private static boolean hasCycle(HashSet<GraphNode> whiteSet, HashSet<GraphNode> blackSet,
			HashSet<GraphNode> greySet) {
		while (!whiteSet.isEmpty()) {
			GraphNode current = whiteSet.iterator().next();
			if (dfs(current, whiteSet, blackSet, greySet)) {
				return true;
			}
		}
		return false;

	}

	//For directed graph.
	private static boolean dfs(GraphNode current, HashSet<GraphNode> whiteSet2, HashSet<GraphNode> blackSet2,
			HashSet<GraphNode> greySet2) {
		moveVertex(current, whiteSet2, greySet2);

		for (GraphNode node : current.adjacentNodes) {
			if (blackSet2.contains(node)) {
				continue;
			}
			if (greySet2.contains(node)) {
				return true;
			}

			if (dfs(node, whiteSet2, blackSet2, greySet2)) {
				return true;
			}
		}
		moveVertex(current, greySet2, blackSet2);
		return false;
	}

	private static void moveVertex(GraphNode current, HashSet<GraphNode> whiteSet2, HashSet<GraphNode> greySet2) {
		whiteSet2.remove(current);
		greySet2.add(current);

	}
	
}
