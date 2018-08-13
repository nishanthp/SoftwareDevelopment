package accpetedSubmissions;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreOrderNAray {

	public static void main(String[] args) {
		// TODO Ran on leetcode.

	}
	
	List<Integer> list = new LinkedList<Integer>();
    public List<Integer> preorder(Node root) {
        if(root == null) return list;
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node c = stack.pop();
            list.add(c.val);
            for(int i=c.children.size()-1; i>=0;i--){
                System.out.println(c.children.get(i).val);
                stack.push(c.children.get(i));
        }
    }    
        return list;
    }

}
