package com.practice.arrays;

public class StockBuyAndSellDemo {
	public static void main(String[] args) {
		int[] input = { 5, 1, 2, 3, 4 };
		int[] input1 = { 1, 4, 5, 7, 6, 3, 2, 9 };
		int prices[] = { 2, 5, 7, 1, 4, 3, 1, 3 };
		StockBuyAndSellDemo demo = new StockBuyAndSellDemo();
		int profit = demo.BSAtmost1Trans(input);
		System.out.println(profit);

		profit = demo.BSAtmostOneTrans(input);
		System.out.println(profit);

		profit = demo.BSAnyNumOfTrans(input1);
		System.out.println(profit);

		profit = demo.BSLimitedNumOfTrans(prices, 3);
		System.out.println(profit);
	}

	public int BSAtmost1Trans(int[] input) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			max = Math.max(max, input[i]);
			min = Math.min(min, input[i]);
		}

		return max - min;
	}

	/**
	 * Assuming 1 transaction but assuming you have not bought the share yet.
	 * 
	 * @param input
	 * @return
	 */
	public int BSAtmostOneTrans(int[] input) {
		int profit = 0;
		for (int i = 1; i < input.length; i++) {
			profit += input[i] - input[i - 1] > 0 ? input[i] - input[i - 1] : 0;
		}
		return profit;
	}

	public int BSAnyNumOfTrans(int[] input) {
		int[] left = new int[input.length];
		int[] right = new int[input.length];
		int max = input[input.length - 1];
		int min = input[0];
		int profit = 0;
		left[0] = 0;
		right[input.length - 1] = 0;
		// Scan the array from left to right.
		for (int i = 1; i < input.length; i++) {
			min = Math.min(min, input[i]);
			left[i] = Math.max(left[i - 1], input[i] - min);
		}

		// Scan the array from right to left.
		for (int i = input.length - 2; i >= 0; i--) {
			max = Math.max(max, input[i]);
			right[i] = Math.max(right[i + 1], max - input[i]);
		}

		for (int i = 0; i < input.length; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}
		return profit;
	}

	public int BSLimitedNumOfTrans(int[] input, int k) {
		int temp[][] = new int[k + 1][input.length];

		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp[0].length; j++) {
				int maxValue = 0;
				for (int m = 0; m <= j-1 ; m++) {
					maxValue = Math.max(input[j]-input[m] + temp[i - 1][m], maxValue);
				}
				temp[i][j] = Math.max(temp[i][j - 1], maxValue);
				 
			}
		}
		return temp[k][input.length - 1];
	}
}
