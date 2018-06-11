package PopularInProb;

import java.util.Arrays;

public class RandomDemo {
	public static void main(String[] args) {

		int[] temp = { 4, 3, 2, 1 };
		Arrays.sort(temp);

		for (int i : temp) {
			System.out.println(i);
		}
	}
}
