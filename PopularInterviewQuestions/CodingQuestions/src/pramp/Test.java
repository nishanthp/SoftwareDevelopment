package pramp;


public class Test {
	public static void main(String[] args) {
		/*
		 * int[] input = { 4, 2, 5, 1 }; Node result_node =
		 * traverseLinkedList(null, input, 0);
		 * System.out.println(result_node.left.left.data);
		 */

		/*
		 * for (int i = 0; i < 9; i++) { int x = (3 * (3 / 3) + i / 3);
		 * System.out.println(x); }
		 */
		/*
		 * String s = "idk"; try { MessageDigest d =
		 * MessageDigest.getInstance("SHA-1"); byte[] a =
		 * d.digest(s.getBytes()); for (byte each : a) {
		 * System.out.println(each); }
		 * System.out.println(DatatypeConverter.printHexBinary(a)); } catch
		 * (NoSuchAlgorithmException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		int a = 99;
		int b = 1;
		swap(a, b);
		/*System.out.println(a);
		System.out.println(b);*/

		Wrapper w = new Wrapper();
		w.a = 99;
		w.b = 1;
		swap(w);
		System.out.println(w.a);
		System.out.println(w.b);

		/*
		 * int[] input = { 1, 2, 3, 4, 5 }; String s = " egjner"; s.length();
		 * for (int temp : input) { System.out.println(temp); }
		 */
	}

	private static void swap(Wrapper w) {
		int temp = w.a;
		w.a = w.b;
		w.b = temp;

	}

	private static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = a;

	}

	// insert in order of array.
	private static Node traverseLinkedList(Node root, int[] input, int index) {
		if (index > input.length - 1) {
			return null;
		}

		if (root == null) {
			root = new Node(input[index]);
		}

		root.left = traverseLinkedList(root.left, input, (2 * index) + 1);
		root.right = traverseLinkedList(root.right, input, (2 * index) + 2);
		return root;
	}

	public int maxSubArray(int[] a) {
		int max = a[0];
		int[] sum = new int[a.length];
		sum[0] = a[0];
		for (int i = 0; i < a.length; i++) {
			sum[i] = Math.max(a[i], sum[i - 1] + a[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}
}

class Wrapper {
	public Wrapper() {
		// TODO Auto-generated constructor stub
	}

	int a;
	int b;
}