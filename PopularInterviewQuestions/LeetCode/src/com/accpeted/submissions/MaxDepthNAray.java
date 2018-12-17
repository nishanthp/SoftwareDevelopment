package com.accpeted.submissions;

public class MaxDepthNAray {

	public static void main(String[] args) {
		// Ran on leetcode.

	}

	int maxDepth = 0;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        //Stack<Node> stack = new Stack<Node>();
        //stack.push(root);     
        //while(!stack.isEmpty()){
            //Node c = stack.pop();
            int depth = 0;
            for(Node child : root.children){
                //stack.push(child);
                depth = Math.max(depth, maxDepth(child));
                maxDepth = Math.max(depth, maxDepth);
            }
        //}
        return 1+depth;
    }
}
