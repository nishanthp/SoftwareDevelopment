package accpetedSubmissions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostOrder {

	public static void main(String[] args) {
		// Ran on leetcode.

	}
	List<Integer> list = new LinkedList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root == null) return list;
        Stack<Node> stack = new Stack<Node>();
        Deque<Integer> queue = new ArrayDeque<Integer>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node c = stack.pop();
            queue.push(c.val);
            for(Node child : c.children){
                stack.push(child);
            }
        }
        return new ArrayList<Integer>(queue);
    }
}
