package PopularInProb;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Pre order serialization and deserialization.
 * 
 * @author prakasni
 *
 */
public class SerializeBinaryTree {
	static StringBuffer buffer = new StringBuffer();

	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(8);
		BinaryNode root_1 = new BinaryNode(9);
		BinaryNode root_2 = new BinaryNode(1);
		BinaryNode root_3 = new BinaryNode(2);
		BinaryNode root_4 = new BinaryNode(3);
		root.left = root_1;
		root.right = root_2;
		root_1.left = root_3;
		root_3.left = root_4;
		SerializeBinaryTree sbt = new SerializeBinaryTree();
		sbt.serializeBinaryTree(root);
		String serializeTree = new String(buffer);
		String newString = serializeTree.substring(0, serializeTree.length() - 1);
		System.out.println(newString);
		BinaryNode newRoot = sbt.deserializeBinaryTree(newString);
		System.out.println(newRoot.right.dat);
	}

	public void serializeBinaryTree(BinaryNode root) {
		if (root == null) {
			buffer.append("null,");
			return;
		}
		buffer.append(root.dat + ",");
		serializeBinaryTree(root.left);
		serializeBinaryTree(root.right);
	}

	public BinaryNode deserializeBinaryTree(String data) {
		Deque<String> nodes = new LinkedList<>();
		nodes.addAll(Arrays.asList(data.split(",")));
		return deserialize(nodes);
	}

	private BinaryNode deserialize(Deque<String> nodes) {
		Object data = nodes.removeFirst();
		if (data.equals("null")) {
			return null;
		}
		int val = Integer.parseInt((String) data);
		BinaryNode root = new BinaryNode(val);
		
		
		
		root.left = deserialize(nodes);
		root.right = deserialize(nodes);
		return root;
	}
}

class BinaryNode {
	int dat;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode(int data) {
		this.dat = data;
	}
}