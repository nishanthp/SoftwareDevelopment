package com.accpeted.submissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;


public class SerializeDeserializeNArray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	
	class Codec {
	    StringBuffer sb = new StringBuffer();
	    // Encodes a tree to a single string.
	    public String serialize(Node15 root) {
	        if(root == null) return "";
	        serializeT(root);
	        return sb.toString();
	    }
	    
	    public void serializeT(Node15 root) {
	        //if(root == null) return null;
	        sb.append(root.val).append(",");
	        sb.append("#").append(String.valueOf(root.children.size())).append(",");
	        for(Node15 curr : root.children){
	            serializeT(curr);
	          }
	        return;
	    }

	    // Decodes your encoded data to tree.
	    public Node15 deserialize(String data) {
	        if(data == null || data.length() == 0) return null;
	        String[] parts = data.split(",");
	        Queue<String> nodes = new LinkedList<String>();
	        nodes.addAll(Arrays.asList(data.split(",")));
	        return deserialize(nodes);
	    }
	    
	    public Node15 deserialize(Queue<String> nodes) {
	        if(nodes.isEmpty()) return null;
	        String rootVal = nodes.remove();
	        String cNum = nodes.remove();
	        int numberOfChildren = Integer.valueOf(cNum.substring(cNum.indexOf("#")+1));
	        Node15 root = new Node15(Integer.valueOf(rootVal));
	        root.children = new ArrayList<Node15>();
	        for(int i=0;i<numberOfChildren;i++){
	            Node15 r = deserialize(nodes);
	            if(r != null) {
	                root.children.add(r);
	            }
	        }
	        return root;
	    }
	}
	class Node15{
		public int val;
	    public List<Node15> children;

	    public Node15() {}
	    
	    public Node15(int _val) {
	        val = _val;
	    }
	    
	    public Node15(int _val,List<Node15> _children) {
	        val = _val;
	        children = _children;
	    }
	}

}
