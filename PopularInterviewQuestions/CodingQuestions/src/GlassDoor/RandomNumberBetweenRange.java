package GlassDoor;

import java.util.Random;

public class RandomNumberBetweenRange {
	public static void main(String[] args) {
		int minRange = 10;
		int maxRange = 100;
		System.out.println(getRandomNumber(minRange, maxRange));
	}

	// When given a range without an array, use binary search (modified because
	// we are not searching for an element. So the search ends when left<right
	// or left==right)
	private static int getRandomNumber(int minRange, int maxRange) {
		int left = minRange;
		int right = maxRange;
		int mid = (left + right) / 2;
		if (left == right) {
			return mid;
		}

		// this is random, go left if true, can be other way round too.
		if (getRandom01s()) {
			return getRandomNumber(left, mid);
		} else {
			return getRandomNumber(mid + 1, right);
		}

	}

	// gives a random of 0s and 1s.
	private static boolean getRandom01s() {
		return new Random().nextBoolean();
	}
}
