package accpetedSubmissions;
import java.util.*;

public class TopologicalSort_Template {

	static Deque<Integer> order = new ArrayDeque<Integer>();
	public static void main(String[] args) {
		// Not on Leetcode.
		Graph g = new Graph();
		for(GNode node : g.allNodes){
			if(node.visit != Vist.VISITED) topologicalSort(node);
		}
		for(Integer each : order){
			System.out.println(each);
		}
	}
	
	public static void topologicalSort(GNode root){
		if(root.visit == Vist.VISITED) return;
		
		for(GNode child : root.children){
			child.visit = Vist.VISITING; 
			topologicalSort(child);
		}
		order.add(root.val);
		root.visit = Vist.VISITED;
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
	Vist visit;
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