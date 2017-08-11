package Tree;

public class CounterTreeDemo {
	static int counter = 0;

	public static void main(String[] args) {
		int[] array = { 3, 1, 2, 3 };
		CounterTreeDemo d = new CounterTreeDemo();
		d.createBST(array);
	}

	public void createBST(int[] array) {
		Node rootNode = null;
		for (int eachElement : array) {
			if (rootNode == null) {
				rootNode = new Node(eachElement);
			} else {
				convertArrytoBST(rootNode, eachElement);
			}
			System.out.println(counter);
		}
	}

	public void convertArrytoBST(Node rootNode, int eachElement) {
		counter++;
		if (eachElement < rootNode.data) {
			if (rootNode.left == null) {
				Node temp = new Node(eachElement);
				rootNode.left = temp;
			} else {
				convertArrytoBST(rootNode.left, eachElement);
			}
		} else {
			if (rootNode.right == null) {
				Node temp = new Node(eachElement);
				rootNode.right = temp;
			} else {
				convertArrytoBST(rootNode.right, eachElement);
			}
		}

	}

}
