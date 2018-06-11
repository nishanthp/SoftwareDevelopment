package popularInProb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class UnionIntersectionArray {
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	ArrayList<Integer> result = new ArrayList<>();

	public static void main(String[] args) {
		int[] input1 = { 1, 3, 4, 5, 6, 7 };
		int[] input2 = { 2, 3, 5, 6 };

		UnionIntersectionArray probS = new UnionIntersectionArray();
		// probS.union(input1, input2, 0, 0);
		probS.intersection(input1, input2, 0, 0);

		/*for (Entry<Integer, Integer> val : map.entrySet()) {
			System.out.println(val.getKey());
		}*/
	}

	public void union(int[] input1, int[] input2, int i, int j) {
		if (i > input1.length - 1 && j > input2.length - 1) {
			return;
		} else if (i > input1.length - 1) {
			addData(input2, j);
			union(input1, input2, i, ++j);
		} else if (j > input2.length - 1) {
			addData(input1, i);
			union(input1, input2, ++i, j);
		} else {
			addData(input1, i);
			addData(input2, j);
			union(input1, input2, ++i, ++j);
		}

	}

	public void intersection(int[] input1, int[] input2, int i, int j) {
		union(input1, input2, i, j);
		for (Entry<Integer, Integer> value : map.entrySet()) {
			if (value.getValue() > 1) {
				System.out.println(value.getKey());
				result.add(value.getKey());
			}
		}
	}

	private void addData(int[] in, int index) {
		if (null == map.get(in[index])) {
			map.put(in[index], 1);

		} else {

			map.put(in[index], map.get(in[index]) + 1);
		}
	}

}
