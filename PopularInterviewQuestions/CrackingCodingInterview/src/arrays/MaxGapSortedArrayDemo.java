package arrays;

public class MaxGapSortedArrayDemo {
	public static void main(String[] args) {
		int[] input = { 7, 2, 1, 3, 4 };
		MaxGapSortedArrayDemo gap = new MaxGapSortedArrayDemo();
		int value = gap.maxGap(input);
		System.out.println(value);
	}

	public int maxGap(int[] input) {
		int maxValue = 0;
		int minValue = Integer.MAX_VALUE;
		// find max and min value.
		for (int i = 0; i < input.length; i++) {
			maxValue = Math.max(maxValue, input[i]);
			minValue = Math.min(minValue, input[i]);
		}

		Bucket[] Buckets = new Bucket[input.length + 1];
		// initialize the buckets.
		for (int i = 0; i < input.length + 1; i++) {
			Buckets[i] = new Bucket();
		}

		/*
		 * calculate interval. (input.length or bucket.length as they are same
		 * in this case.)
		 */
		double interval = (double) input.length / (maxValue - minValue);

		// sort into buckets.
		for (int i = 0; i < input.length; i++) {
			int index = (int) ((input[i] - minValue) * interval);
			if (Buckets[index].low == -1 && Buckets[index].high == -1) {
				Buckets[index].low = input[i];
				Buckets[index].high = input[i];
			} else {
				Buckets[index].low = Math.min(Buckets[index].low, input[i]);
				Buckets[index].high = Math.max(Buckets[index].high, input[i]);
			}
		}

		// Traverse through the buckets.
		int previousHigh = Buckets[0].high;
		int maxGap = 0;
		for (int i = 0; i < Buckets.length; i++) {
			if (Buckets[i].low != -1) {
				maxGap = Math.max(Buckets[i].low - previousHigh, maxGap);
				previousHigh = Buckets[i].high;
			}
		}
		return maxGap;
	}
}

class Bucket {
	int low;
	int high;

	public Bucket() {
		low = -1;
		high = -1;
	}
}
