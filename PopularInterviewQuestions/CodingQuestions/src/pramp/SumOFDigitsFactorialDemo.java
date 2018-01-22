package pramp;

import java.util.ArrayList;
import java.util.Vector;

public class SumOFDigitsFactorialDemo {
	ArrayList<Integer> tempResult = new ArrayList<>();

	public static void main(String[] args) {
		SumOFDigitsFactorialDemo d = new SumOFDigitsFactorialDemo();
		System.out.println(d.findSumofDigits(100));
	}

	private int findSumofDigits(int result) {
		tempResult.add(1);
		for (int i = 1; i <= result; i++) {
			multiply(tempResult, i);
		}

		int sum = 0;
		for (Integer eachDigit : tempResult) {
			sum += eachDigit;
		}
		return sum;
	}

	public void multiply(ArrayList<Integer> list, int number) {
		int carry = 0;
		int result = 0;
		for (int i = 0; i < list.size(); i++) {
			result = carry + list.get(i) * number;
			list.set(i, result % 10);
			carry = result / 10;
		}

		while (carry != 0) {
			list.add(carry % 10);
			carry = carry / 10;
		}
	}
}
