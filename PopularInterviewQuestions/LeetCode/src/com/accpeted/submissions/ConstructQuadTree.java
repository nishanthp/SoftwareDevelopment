package com.accpeted.submissions;

public class ConstructQuadTree {

	public static void main(String[] args) {
		// Ran on leetcode

	}
	
	// Similar to constructing a tree. 
    public Node construct(int[][] grid) {
        return constructQuad(grid, 0, grid.length-1, 0, grid[0].length-1);
    }
    
    public Node constructQuad(int[][] grid, int rB, int rE, int cB, int cE) {
        if(rB == rE) return new Node(grid[rB][cB] == 1 ? true : false, true, null, null, null, null);
        int rowMid = (rB + rE)/2;
        int colMid = (cB + cE)/2;
        Node topLeft = constructQuad(grid, rB, rowMid, cB, colMid);
        Node topRight = constructQuad(grid, rB, rowMid, colMid+1, cE);
        Node bottomLeft = constructQuad(grid, rowMid+1, rE, cB, colMid);
        Node bottomRight = constructQuad(grid, rowMid+1, rE, colMid+1, cE);
        if(isSame(topLeft,topRight,bottomLeft,bottomRight)) {
            return new Node(topLeft.val, true, null, null, null, null);
        }
        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
    
    private boolean isSame(Node topLeft, Node topRight, Node bottomLeft, Node bottomRight){
        boolean isSameVal = topLeft.val == topRight.val && topRight.val == bottomLeft.val && bottomLeft.val == bottomRight.val;
        if(!isSameVal) return false;
        return  topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf;
    }
    
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    }

}
