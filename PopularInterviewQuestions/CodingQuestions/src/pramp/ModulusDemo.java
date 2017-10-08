package newSet;

import java.util.ArrayList;
import java.util.Arrays;

public class ModulusDemo {
	public static void main(String[] args) {
		int[] input = new int[3];
		input[0] = 6;
		input[1] = 38;
		input[2] = 34;
		ModulusDemo d = new ModulusDemo();
		for (Integer n : d.equalModulus(input)) {
			System.out.println(n);
		}
	}

	public ArrayList<Integer> equalModulus(int[] input) {
		ArrayList<Integer> result = new ArrayList<>();
		Arrays.sort(input);
		int difference = input[input.length - 1] - input[0];
		ArrayList<Integer> divisors = findDivisors(difference);

		for (int i = 0; i < divisors.size(); i++) {
			int temp = input[0] % divisors.get(i);
			for (int j = 1; j < input.length; j++) {
				if (temp != input[j] % divisors.get(i)) {
					break;
				}
				if (!result.contains(divisors.get(i))) {
					result.add(divisors.get(i));
				}
			}
		}

		return result;
	}

	private ArrayList<Integer> findDivisors(int difference) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 1; i * i <= difference; i++) {
			if (difference % i == 0) {
				list.add(i);
				if (difference / i != i) {
					list.add(difference / i);
				}
			}
		}
		return list;

	}
}
