/**
 * Copyright 2016 Hewlett-Packard Development Company, L.P.
 */
package practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * TODO Administrator (May 9, 2016) - Insert a description of this type.
 *
 * @author Administrator
 */
public class BucketSort {

	public static void main(String[] args) {
		int input[] = { 7, 6, 5, 4, 3, 21 };
		BucketSort sort = new BucketSort();
		for (int i : sort.sort(input)) {
			System.out.println(i);
		}
	}

	public int[] sort(int[] input) {
		int[] results = new int[input.length];
		final int bucket_size = 5;
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();

		// find min and max of the input array.

		int minValue = Integer.MAX_VALUE;
		int maxValue = Integer.MIN_VALUE;

		for (int i = 0; i < input.length; i++) {
			maxValue = Math.max(maxValue, input[i]);
			minValue = Math.min(minValue, input[i]);
		}

		int bucketCount = (maxValue - minValue) / bucket_size + 1;

		// initialization.
		for (int i = 0; i <= bucketCount; i++) {
			buckets.add(new ArrayList<Integer>());
		}

		// fill the buckets.
		for (int eachEntry : input) {
			buckets.get((eachEntry - minValue) / bucket_size).add(eachEntry);
		}

		int currentIndex = 0;
		for (ArrayList<Integer> eachBucket : buckets) {
			Integer[] temp = new Integer[eachBucket.size()];
			temp = eachBucket.toArray(temp);
			Arrays.sort(temp);

			for (int i = 0; i < temp.length; i++) {
				results[currentIndex++] = temp[i];
			}

		}
		return results;
	}

}
