package glassDoor;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintKClosestElementDemo {
	public static void main(String[] args) {
		int[] input = { 12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56 };
		int num = 35;
		int k = 4;
		for (Integer i : findKPoints(input, num, k)) {
			System.out.println(i);
		}
	}

	private static ArrayList<Integer> findKPoints(int[] input, int num, int k) {
		ArrayList<Integer> list = new ArrayList<>();
		int index = searchElement(input, 0, input.length - 1, num);
		System.out.println(index);
		if (index != -1) {
			int left = index - 1;
			int right = index + 1;
			while (left >= 0 && right <= input.length && list.size() < k) {
				if (input[index] - input[left] < input[right] - input[index]) {
					list.add(input[left]);
					left--;
				} else {
					list.add(input[right]);
					right++;
				}
			}

			while (list.size() < k && right <= input.length) {
				list.add(input[right]);
				right++;

			}

			while (list.size() < k && left >= 0) {
				list.add(input[left]);
				left--;

			}

		} else {
			return null;
		}
		return list;
	}

	private static int searchElement(int[] input, int left, int right, int num) {
		int mid = (left + right) / 2;
		if (right < left || left < 0 || right > input.length - 1) {
			return -1;
		}
		if (input[mid] == num) {
			return mid;
		}

		if (input[mid] > num) {
			return searchElement(input, left, mid - 1, num);
		} else {
			return searchElement(input, mid + 1, right, num);
		}

	}
}
