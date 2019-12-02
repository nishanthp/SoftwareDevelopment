package com.common.templates;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {

	public static void main(String[] args) {
		// 1. BFS on BST and BT.
		// 2. BFS on graph.
		// 3. BFS shortest path.
		BTNode root = null;
		GraphNode startNode = null;

		BFSOnBinaryTree(root);
		BFSOnGraph(startNode);

		int[][] graph = {{0, 1, 100}, {1, 2, 200}, {2, 1, 150}};
		BFSOnGraphShortestPath(graph);
	}

	private static void BFSOnBinaryTree(BTNode root) {
		Queue<BTNode> queue = new LinkedList<BTNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			BTNode curr = queue.remove();
			System.out.println(curr.val);
			if (curr.left != null) {
				queue.offer(curr.left);
			}
			if (curr.right != null) {
				queue.offer(curr.right);
			}
		}
		return;
	}

	private static void BFSOnGraph(GraphNode startNode) {
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(startNode);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				GraphNode curr = queue.remove();
				System.out.println(curr.val);
				for (GraphNode curr_neighbor : curr.neighbors) {
					queue.offer(curr_neighbor);
				}
			}
		}
		return;
	}

	private static void BFSOnGraphShortestPath(int[][] graph) {
		HashMap<Integer, PriorityQueue<Neighbor>> gNodes = new HashMap<Integer, PriorityQueue<Neighbor>>();
		for (int[] each : graph) {
			gNodes.putIfAbsent(each[0],
					new PriorityQueue<Neighbor>(new Comparator<Neighbor>() {
						@Override
						public int compare(Neighbor n1, Neighbor n2) {
							return n1.cost.compareTo(n2.cost);
						}
					}));
			gNodes.get(each[0]).offer(new Neighbor(each[1], each[2]));
		}
		dfs(gNodes, 0);
	}

	// Find the shortest path.
	private static void dfs(HashMap<Integer, PriorityQueue<Neighbor>> gNodes,
			int currNode) {
		if (!gNodes.containsKey(currNode))
			return;
		for (Neighbor next : gNodes.get(currNode)) {
			dfs(gNodes, next.next);
		}
		return;
	}

}

class Neighbor {
	Integer cost;
	Integer next;
	public Neighbor(int cost, int next) {
		this.cost = cost;
		this.next = next;
	}
}

class BTNode {
	BTNode left;
	BTNode right;
	int val;
}

class GraphNode {
	List<GraphNode> neighbors = new ArrayList<GraphNode>();
	int val;
}