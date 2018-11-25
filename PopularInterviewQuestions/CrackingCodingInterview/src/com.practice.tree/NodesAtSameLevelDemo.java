package tree;

import java.util.ArrayList;
import java.util.LinkedList;

public class NodesAtSameLevelDemo {
	static ArrayList<LinkedList<Integer>> lists = new ArrayList<>();

	public static void main(String[] args) {
		Node root = new Node(10);
		Node root1 = new Node(6);
		Node root2 = new Node(12);
		Node root3 = new Node(5);
		Node root4 = new Node(7);

		root.left = root1;
		root.right = root2;
		root1.left = root3;
		root1.right = root4;
		sameLevelNodes(root, 0);

		for (LinkedList<Integer> eachList : lists) {
			for (Integer each : eachList) {
				System.out.print(each + "  -->  ");
			}
			System.out.println();
		}
	}

	private static void sameLevelNodes(Node root, int level) {
		if (root == null) {
			return;
		}

		LinkedList<Integer> list = null;
		if (level == lists.size()) {
			list = new LinkedList<>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root.data);
		sameLevelNodes(root.left, level + 1);
		sameLevelNodes(root.right, level + 1);
	}
}
