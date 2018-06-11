package msft;

import java.util.HashSet;
import java.util.PriorityQueue;

public class KthSmallestDistinctSumDemo {
	public static void main(String[] args) {
		int[] x = { 1, 2, 4, 6 };
		int[] y = { 2, 3, 5, 8, 10 };
		int k = 3;
		PriorityQueue<Integer> res = findKLeastSum(x, y, k);
		int leastSum = 0;
		while (k > 0) {
			leastSum = res.poll();
			k--;
		}
		System.out.println(leastSum);
	}

	private static PriorityQueue<Integer> findKLeastSum(int[] x, int[] y, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		HashSet<Integer> set = new HashSet<>();
		int i = 0;
		int j = 0;
		// has to be the lowest.
		int sum = x[i] + y[j];
		set.add(sum);
		minHeap.add(sum);
		while (minHeap.size() < k) {
			sum = x[i] + y[j];
			if (!set.contains(sum)) {
				set.add(sum);
				minHeap.add(sum);
			}
			if (i < x.length - 1) {
				sum = x[i + 1] + y[j];
				if (!set.contains(sum)) {
					set.add(sum);
					minHeap.add(sum);
				}
			} else
				break;
			if (j < y.length - 1) {
				sum = x[i] + y[j + 1];
				if (!set.contains(sum)) {
					set.add(sum);
					minHeap.add(sum);
				}
			} else
				break;
			i++;
			j++;
		}

		return minHeap;
	}
}
