package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return clone(node);
    }
    
    public UndirectedGraphNode clone(UndirectedGraphNode node) {
       if(node == null) return null;
       if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for(UndirectedGraphNode each : node.neighbors){
            clone.neighbors.add(clone(each));
        }
        return clone;
    }
    // Can be a design and solve question.
    class UndirectedGraphNode {
    	int label;
    	 List<UndirectedGraphNode> neighbors;
    	 UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    	
    }

}
