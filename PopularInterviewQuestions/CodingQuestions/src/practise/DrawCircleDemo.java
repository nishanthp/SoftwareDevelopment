package practise;

import java.util.ArrayList;
import java.util.List;

public class DrawCircleDemo {
	public static void main(String[] args) {
		/*
		 * int r = 3; int N = 2 * r + 1; for (int i = 0; i < N; i++) { for (int
		 * j = 0; j < N; j++) { int x = i - r; int y = j - r; if (x * x + y * y
		 * <= r * r + 1) { System.out.print("."); } else
		 * System.out.println(" "); // System.out.println(" "); }
		 * System.out.println(); }
		 */
		for (Integer[] point : drawCircle(2)) {
			System.out.println(point[0] + " " + point[1]);
		}
	}

	public static List<Integer[]> drawCircle(int radius) {
		ArrayList<Integer[]> list = new ArrayList<>();
		// n stores r^2
		int n = radius * radius;

		for (int i = 0; i <= radius; i++) {
			for (int j = 0; j <= radius; j++) {
				// check the condition
				if (i * i + j * j <= n) {
					if (i == 0 && j == 0) {
						list.add(new Integer[] { i, j });
					}
					else if (i == 0) {
						list.add(new Integer[] { i, j });
						list.add(new Integer[] { i, -j });
					}
					else if (j == 0) {
						list.add(new Integer[] { i, j });
						list.add(new Integer[] { -i, j });
					} else {
						list.add(new Integer[] { i, j });
						list.add(new Integer[] { i, -j });
						list.add(new Integer[] { -i, j });
						list.add(new Integer[] { -i, -j });
					}
				}
			}
		}
		return list;
	}
}
