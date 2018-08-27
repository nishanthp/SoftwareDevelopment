package practise;
import java.util.*;

public class TopologicalSort_Template {

	static Deque<Integer> order = new ArrayDeque<Integer>();
	public static void main(String[] args) {
		GNode n1 = new GNode(1);
		GNode n2 = new GNode(2);
		GNode n3 = new GNode(3);
		GNode n4 = new GNode(4);
		GNode n5 = new GNode(5);
		n1.addChild(n3);
		n2.addChild(n4);
		n3.addChild(n5);
		n4.addChild(n3);
		n4.addChild(n5);
		
		List<GNode> list = new ArrayList<GNode>();
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);	
		// Not on Leetcode.
		Graph g = new Graph();
		g.addAll(list);

		for(GNode node : g.allNodes){
			if(node.visit != Vist.VISITED) {
				topologicalSort(node);
			}
		}
		for(Integer each : order){
			System.out.println(each);
		}
	}
	
	public static void topologicalSort(GNode root){
		if(root.visit == Vist.VISITED) return;
		root.visit = Vist.VISITING;
		for(GNode child : root.children){
			topologicalSort(child);
		}
		root.visit = Vist.VISITED;
		order.add(root.val);	
	}
}

class Graph{
	List<GNode> allNodes = new ArrayList<GNode>();
	void addAll(List<GNode> nodes){
		for(GNode node : nodes){
			allNodes.add(node);
		}
	}

	List<GNode> getAllNodes(){
		return allNodes;
	}
}

class GNode {
	int val;
	Vist visit = Vist.UNVISITED;
	List<GNode> children = new ArrayList<GNode>();
	GNode(int val){
		this.val = val;
	}
	void addChild(GNode child){
		children.add(child);
	}
	
	List<GNode> getChildren(){
		return children;
	}
	
}

enum Vist {
	UNVISITED, VISITING, VISITED
}