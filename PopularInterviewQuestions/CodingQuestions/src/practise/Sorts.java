/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

import java.io.FileNotFoundException;

/**
 * TODO Administrator (May 8, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class Sorts {

	/**
	 * TODO Administrator (May 8, 2016) - Insert a description of what this
	 * method does.
	 *
	 * @param args
	 * @throws FileNotFoundException
	 */
	final static int am = 9;
	private static final int l = 0;

	public static void main(final String[] args) throws FileNotFoundException {
		/*
		 * final int[] a = { 4, 5, 3, 2, 1, 8 }; final int[] h = new int[6];
		 * final int low = 0; final int high = a.length - 1; final String b[] =
		 * { "acre", "gwergdfh", "race", "erwetwt", "care" }; int n = 12 > 30 ?
		 * 1 : 0; // n = 12 / 10; System.out.println(n); n = 12 % 10;
		 * System.out.println(n);
		 */
		/*
		 * final int a[] = { 5, 2, 3, 1, 6 }; final BubbleSort bs = new
		 * BubbleSort(); bs.bubbleSort(a); for (final int each : a) {
		 * System.out.println(each); }
		 */

		/*
		 * final SubSetProblem s = new SubSetProblem(); s.palindrome("nitiin");
		 */

		final SubString s = new SubString();
		// s.permutation("abc");

		/*
		 * final int input[][] = { { 2, 1, -3, -4, 5 }, { 0, 6, 3, 4, 1 }, { 2,
		 * -2, -1, 4, -5 }, { -3, 3, 1, 0, 3 } }; final TwoDSubMatrix two = new
		 * TwoDSubMatrix(); final TwoDSubMatrix t = new TwoDSubMatrix(); Result
		 * r = new Result(); r = two.maxSum(input); System.out.println("LEFT" +
		 * r.leftBound); System.out.println("RIGHT" + r.rightBound);
		 * System.out.println("LOW" + r.lowBound); System.out.println("RIGHT" +
		 * r.upBound); System.out.println("SUM" + r.maxSum);
		 */

		/*
		 * final Node root4 = new Node(8, null, null); final Node root5 = new
		 * Node(9, null, null); final Node root3 = new Node(2, root5, root4);
		 * final Node root11 = new Node(14, null, null); final Node root2 = new
		 * Node(30, root11, root3); final Node root9 = new Node(5, null, null);
		 * final Node root8 = new Node(3, root9, null); final Node root6 = new
		 * Node(6, null, null); final Node root7 = new Node(15, root8, root6);
		 * final Node root1 = new Node(10, root7, root2); final BT binarTree =
		 * new BT();
		 */
		// binarTree.postorder(root1);
		// binarTree.preorder(root1);
		// binarTree.inorder(root1);
		/*
		 * final Node1 root23 = new Node1(10); final AVL avl = new AVL();
		 * avl.insert(root23, 10); avl.insert(root23, 5); avl.insert(root23,
		 * -10); avl.insert(root23, -20);
		 * System.out.println(binarTree.size(root1));
		 * System.out.println(binarTree.height(root1));
		 * System.out.println(binarTree.heightDiff(root1));
		 */
		// mergeSort(a, h, low, high);

		final QuickSort quickSort = new QuickSort();
		// quickSort.quickSort(a, low, high);
		/*
		 * final SelectionSort s1 = new SelectionSort(); final int s23[] = { 5,
		 * 4, 3, 2, 1 }; s1.SelectionSort(s23);
		 */
		final int[] s34 = { 5, 213, 55, 21, 2334, 31, 20, 430 };
		/*
		 * final RadixSort rs = new RadixSort(); rs.radixSort(s34);
		 */

		/*
		 * final BucketSort bucketSort = new BucketSort(); for (final String
		 * element : bucketSort.bucketSort(b)) { System.out.println(element); }
		 */
		/*
		 * final BFS bfs = new BFS(); bfs.createGraph();
		 */
		/*
		 * final int[][] test = { { 1, 2, 3 }, { 3, 4, 5 } };
		 * System.out.println(test.length);
		 */
		/*
		 * final int deno[] = { 1, 2, 3 }; final SolutionChanges s1 = new
		 * SolutionChanges(); System.out.println(s1.numberofSolutions(deno, 5));
		 */
		/*
		 *  final NQueenProblem
		 * queen = new NQueenProblem(); for (final Positions p :
		 * queen.queenNProblem(4)) { System.out.println("ROW:" + p.row + "COL:"
		 * + p.col); }
		 */
		/*
		 * final int a[] = { 7, 3, 4, 5, 9 }; final QuickSelect qs = new
		 * QuickSelect(); System.out.println(qs.kthLargestElement(3, a));
		 */
		/*
		 * final int sw1 = 10; final int sw2 = 22; final Swap swap = new Swap();
		 * swap.method1(sw1, sw2); System.out.println(sw1);
		 * System.out.println(sw2);
		 */
		final Fibonacci f = new Fibonacci();
		/*
		 * System.out.println(f.fibonacci(6));
		 * System.out.println(f.reverseStringRec("Nishanth"));
		 */
		System.out.println(f.reversenumberPali(1331));

		/*
		 * final PrintStream p = new PrintStream(new File("C:\\NewFile"));
		 * System.setOut(p);
		 */
		/*
		 * final Integer n = 127; final Integer m = 127; if (m == n) {
		 * System.out.println("Same"); } else { System.out.println("Not same");
		 * }
		 */
		/*
		 * final int[] n = { 1, 3, 4, 5, 6 }; final int[] m = { 1, 3, 4, 5, 6 };
		 * final Object[] m1 = { m }; final Object[] n1 = { n }; if
		 * (Arrays.deepEquals(n1, m1)) { System.out.println(m1.toString()); }
		 */
		/*
		 * final int r = 6; final int[][] mn = new int[r][]; for (int i = 0; i <
		 * mn.length; i++) { mn[i] = new int[i + 1]; } for (final int[] element
		 * : mn) { for (final int element2 : element) {
		 * System.out.print(element2); } System.out.println(""); }
		 */

		/*
		 * final Sorts.StaticNestedClass staticNestedClass = new
		 * Sorts.StaticNestedClass(); staticNestedClass.display(); final
		 * Sorts.NestedClass nested = new Sorts().new NestedClass();
		 * nested.display(); final String x = "Geeks1for2Geeks"; final String
		 * delimiter = "\\D"; final Pattern comp = Pattern.compile("G{1}",
		 * Pattern.CASE_INSENSITIVE); final Matcher matcher = comp.matcher(x);
		 * final String[] something = comp.split(x); for (final String one :
		 * something) { System.out.println(one); } while (matcher.find()) {
		 * System.out.println(matcher.start()); }
		 */
		/*
		 * final ArrayList<String> array = new ArrayList<String>();
		 * array.add("Heeelt"); array.add("Hlt"); array.add("Heeet"); final
		 * ListIterator<String> it = array.listIterator(); while (it.hasNext())
		 * { System.out.println(it.next()); } while (it.hasPrevious()) {
		 * System.out.println(it.previous()); }
		 */
		/*
		 * final HashSet<Integer> ha = new HashSet<Integer>(); ha.add(1);
		 * ha.add(1); ha.add(2); ha.add(3); final HashSet<Integer> hb = new
		 * HashSet<Integer>(); hb.add(1); hb.add(4); hb.add(5); hb.add(5);
		 */

		// union of two sets.
		/*
		 * ha.addAll(hb); System.out.println(ha.toString());
		 */
		// intersection
		/*
		 * ha.retainAll(hb); System.out.println(ha.toString());
		 */
		// difference
		/*
		 * ha.removeAll(hb); System.out.println(ha.toString());
		 */
		/*
		 * final Double d = new Double(2.5); final byte byteq = d.byteValue();
		 * System.out.println(byteq);
		 */

		final int c[] = { 1, 2, 3, 4 };
		final int val = 5;
		System.out.println(countpairsn(c, val));

		/*
		 * String s = null; final String time = "12:00:00AM"; if
		 * (time.contains("P")) { s = time.substring(0, time.indexOf("PM")); }
		 * else { s = time.substring(0, time.indexOf("AM")); } final String[]
		 * arr = s.split(":"); for (final String element : arr) {
		 * System.out.println(element); } final ArrayList<TreeSet<String>> tree
		 * = new ArrayList<TreeSet<String>>(); final Set<String> ser = new
		 * TreeSet<String>(); final Set<String> se1 = new TreeSet<String>();
		 * final boolean bi = ser.retainAll(se1); final String ad = "Nishanth";
		 * ser.retainAll(se1); final ArrayList<ArrayList<String>> arrq = new
		 * ArrayList<ArrayList<String>>(); final ArrayList<Integer> rwrgferff1 =
		 * new ArrayList<Integer>(); arrq.add(rwrgferff1); //
		 * System.out.println(countpairs(c, val)); Integer n = new Integer(10);
		 */
		/*
		 * System.out.println(Math.pow(2, 3)); final Sorts s = new Sorts();
		 * final int c;
		 */
	}

	/**
	 * TODO Administrator (May 17, 2016) - Insert a description of what this
	 * method does.
	 *
	 * @param c
	 * @param val
	 * @return
	 */
	private static int countpairsn(final int[] c, final int val) {
		final boolean[] b = new boolean[500];
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			final int temp = val - c[i];
			if (temp > 0 && b[temp]) {
				count++;
			}
			b[c[i]] = true;
		}
		return count;
	}

	/**
	 * TODO Administrator (May 17, 2016) - Insert a description of what this
	 * method does.
	 *
	 * @param val
	 * @param c
	 */
	private static int countpairs(final int[] c, final int val) {
		int count = 0;
		for (int i = 0; i < c.length; i++) {
			for (int j = i + 1; j < c.length; j++) {

				if (c[i] + c[j] == val) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * TODO Administrator (May 8, 2016) - Insert a description of what this
	 * method does.
	 *
	 * @param a
	 * @param h
	 * @param high
	 * @param low
	 */
	private static void mergeSort(final int[] a, final int[] h, final int low, final int high) {
		if (low < high) {
			final int middle = (low + high) / 2;
			mergeSort(a, h, low, middle);
			mergeSort(a, h, middle + 1, high);
			merge(a, h, low, middle, high);
		}
	}

	/**
	 * TODO Administrator (May 8, 2016) - Insert a description of what this
	 * method does.
	 *
	 * @param high
	 * @param low
	 * @param h
	 * @param a
	 * @param high2
	 */
	private static void merge(final int[] a, final int[] h, final int low, final int middle, final int high) {
		for (int i = 0; i < a.length; i++) {
			h[i] = a[i];
		}
		int helperLeft = low;
		int helperRight = middle + 1;
		int current = low;
		while (helperLeft <= middle && helperRight <= high) {
			if (h[helperLeft] <= h[helperRight]) {
				a[current] = h[helperLeft];
				helperLeft++;
			} else if (h[helperLeft] >= h[helperRight]) {
				a[current] = h[helperRight];
				helperRight++;
			}
			current++;
		}
		final int remaining = middle - helperLeft;
		for (int i = 0; i <= remaining; i++) {
			a[current + i] = h[helperLeft + i];
		}

	}

	public static class StaticNestedClass {

		public void display() {
			System.out.println("Ststic nested class." + Sorts.l);
		}
	}

	public class NestedClass {

		public void display() {
			System.out.println("Nested inner class." + Sorts.l);
		}
	}

}
