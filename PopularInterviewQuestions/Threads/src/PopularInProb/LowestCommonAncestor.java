package PopularInProb;
import java.util.HashMap;
import java.util.LinkedHashMap;
public class LowestCommonAncestor {
	public static void main(String[] args) {
		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
		map.put(1, 2);
		HashMap<Integer, Integer> k = new HashMap<>();
		k.put(1, 2);
		LCANode root = new LCANode(7);
		LCANode node1 = new LCANode(3);
		LCANode node2 = new LCANode(4);
		LCANode node3 = new LCANode(2);
		LCANode node4 = new LCANode(1);
		root.left = node1;
		root.right = node2;
		node1.left = node3;
		node1.right = node4;
		LowestCommonAncestor lca = new LowestCommonAncestor();
		LCANode commonNode = lca.findLowestCommonAncestor(root, node2, node4);
		System.out.println(commonNode.data);
	}

	public LCANode findLowestCommonAncestor(LCANode root, LCANode p, LCANode q) {
		Boolean p_on_left_side = searchLeftSideofBinaryTree(root.left, p);
		Boolean q_on_left_side = searchLeftSideofBinaryTree(root.left, q);
		if (p_on_left_side != q_on_left_side) {
			return root;
		}
		if (p_on_left_side == true) {
			return findLowestCommonAncestor(root.left, p, q);
		} else {
			return findLowestCommonAncestor(root.right, p, q);
		}

	}

	public Boolean searchLeftSideofBinaryTree(LCANode root, LCANode reqNode) {
		if (root == null) {
			return false;
		}
		if (root.data == reqNode.data) {
			return true;
		}

		return searchLeftSideofBinaryTree(root.left, reqNode) || searchLeftSideofBinaryTree(root.right, reqNode);

	}
}

class LCANode {
	int data;
	LCANode left;
	LCANode right;

	public LCANode(int dat) {
		this.data = dat;
	}

}
