package accpetedSubmissions;

import java.util.List;
import java.util.Stack;

public class GraphStackvsQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int maxDepth = 0;
    public int maxDepth(Node root) {
        Stack<Node> stack = new Stack<Node>();
        //Deque<Node> stack = new LinkedList<Node>();
        stack.push(root);
        //stack.add(root);
        while(!stack.isEmpty()){
            Node c = stack.pop();
            //Node c = stack.remove();
            System.out.println(c.val);
            for(Node child : c.children){
                //maxDepth(child);
                //stack.add(child);
                stack.push(child);
                //System.out.println(child.val);
            }
        }
        return 0;
    }

}

class Node {
	public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}