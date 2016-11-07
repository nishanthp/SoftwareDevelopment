package PopularInProb;

import java.nio.Buffer;

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
		System.out.println(new String(buffer));
		System.out.println(newString);
		BinaryNode newRoot = sbt.deserializeBinaryTree(newString);
		System.out.println(newRoot.right.right.dat);
	}

	public void serializeBinaryTree(BinaryNode root) {
		if (root == null) {
			return;
		}
		buffer.append(root.dat);
		buffer.append(",");
		serializeBinaryTree(root.left);
		serializeBinaryTree(root.right);
	}

	public BinaryNode deserializeBinaryTree(String data) {
		String[] input = data.split(",");
		return deserialize(input, 0);
	}

	private BinaryNode deserialize(String[] input, int i) {
		if (i > input.length - 1) {
			return null;
		}
		int val = Integer.parseInt(input[i]);
		BinaryNode root = new BinaryNode(val);
		root.left = deserialize(input, ++i);
		root.right = deserialize(input, ++i);
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