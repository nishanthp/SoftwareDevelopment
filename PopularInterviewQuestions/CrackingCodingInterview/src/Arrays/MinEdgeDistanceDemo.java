package Arrays;

import java.util.Calendar;

import javax.swing.plaf.SliderUI;

public class MinEdgeDistanceDemo {
	public static void main(String[] args) {
		String str1 = "sunday";
		String str2 = "saturday";
		int distance = calculateDistance(str1, str2, str1.length(), str2.length());
		System.out.println(distance);
	}

	static int calculateDistance(String s1, String s2, int s1l, int s2l) {
		if (s1l == 0)
			return s2l;
		if (s2l == 0)
			return s1l;
		if (s1.charAt(s1l - 1) == s2.charAt(s2l - 1))
			return calculateDistance(s1, s2, s1l - 1, s2l - 1);
		return 1 + Math.min(Math.min(calculateDistance(s1, s2, s1l - 1, s2l), calculateDistance(s1, s2, s1l, s2l - 1)),
				calculateDistance(s1, s2, s1l - 1, s2l - 1));

	}
}
